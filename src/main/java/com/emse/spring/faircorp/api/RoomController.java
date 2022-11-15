package com.emse.spring.faircorp.api;
import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;
import com.emse.spring.faircorp.dao.RoomDao;
import java.util.stream.Collectors;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/building/{building_id}/room")
public class RoomController {

    private final RoomDao roomDao;
    private BuildingDao buildingDao;

    public RoomController(RoomDao roomDao, BuildingDao buildingDao) {
        this.roomDao = roomDao;
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<RoomDto> findBybuildingId(@PathVariable Long building_id) {
        return roomDao.findBybuildingId(building_id).stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }

    @PostMapping()
    public RoomDto create(@PathVariable Long building_id, @RequestBody RoomDto roomDto) throws Exception {
        Building building = buildingDao.getReferenceById(building_id);
        if(building == null) throw new Exception();
        Room room = null;
        if (roomDto.getId() == null) {
            room = roomDao.save(new Room(roomDto.getName(), roomDto.getFloor(), roomDto.getCurrent_temperature(), roomDto.getTarget_temperature(), building));
        } else {
            room = roomDao.getReferenceById(roomDto.getId());
            room.setFloor(roomDto.getFloor());
            room.setName(roomDto.getName());
            room.setCurrent_temperature(roomDto.getCurrent_temperature());
            room.setTarget_temperature(roomDto.getTarget_temperature());
            room.setBuilding(building);
            room = roomDao.save(room);
        }
        return new RoomDto(room);
    }

}
