package com.emse.spring.faircorp.api;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.HeaterStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/heater")
public class HeaterController {

    private HeaterDao heaterDao;
    private RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null);
    }

    @PutMapping(path = "/{id}/switch")
    public HeaterDto switchStatus(@PathVariable Long id) {
        Heater heater = heaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
        heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        heater = heaterDao.save(heater);
        return new HeaterDto(heater);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }

    @PostMapping
    public HeaterDto create(@RequestBody HeaterDto heaterDto) {
        Room room = roomDao.getReferenceById(heaterDto.getRoomId());
        Heater heater = null;
        if (heaterDto.getId() == null) {
            heater = heaterDao.save(new Heater(heaterDto.getName(), heaterDto.getHeaterStatus(), heaterDto.getPower(), room));
        } else {
            heater = heaterDao.getReferenceById(heaterDto.getId());
            heater.setName(heaterDto.getName());
            heater.setHeaterStatus(heaterDto.getHeaterStatus());
            heater.setPower(heaterDto.getPower());
            heater.setRoom(room);
            heater = heaterDao.save(heater);
        }
        return new HeaterDto(heater);
    }

}
