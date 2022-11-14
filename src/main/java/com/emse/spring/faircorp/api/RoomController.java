package com.emse.spring.faircorp.api;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;
import com.emse.spring.faircorp.dao.RoomDao;
import java.util.stream.Collectors;
import java.util.List;

@RestController
@RequestMapping("api/room")
public class RoomController {

    private final RoomDao roomDao;

    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
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
    public RoomDto create(@RequestBody RoomDto roomDto) {
        Room room = null;
        if (roomDto.getId() == null) {
            room = roomDao.save(new Room(roomDto.getName(), roomDto.getFloor(), roomDto.getCurrent_temperature(), roomDto.getTarget_temperature()));
        } else {
            room = roomDao.getReferenceById(roomDto.getId());
            room.setFloor(roomDto.getFloor());
            room.setName(roomDto.getName());
            room.setCurrent_temperature(roomDto.getCurrent_temperature());
            room.setTarget_temperature(roomDto.getTarget_temperature());
            room = roomDao.save(room);
        }
        return new RoomDto(room);
    }

}
