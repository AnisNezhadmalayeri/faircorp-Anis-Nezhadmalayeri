package com.emse.spring.faircorp.api;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/window")
public class WindowController {
    private WindowDao windowDao;
    private RoomDao roomDao;

    public WindowController(WindowDao windowDao, RoomDao roomDao) {
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<WindowDto> findAll() {
        return windowDao.findAll().stream().map(WindowDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public WindowDto findById(@PathVariable Long id) {
        return windowDao.findById(id).map(WindowDto::new).orElse(null); // (7)
    }

    @PutMapping(path = "/{id}/switch")
    public WindowDto switchStatus(@PathVariable Long id) {
        Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        window = windowDao.save(window);
        return new WindowDto(window);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteById(id);
    }

    @PostMapping
    public WindowDto create(@RequestBody WindowDto windowDto) {
        Room room = roomDao.getReferenceById(windowDto.getRoomId());
        Window window = null;
        if (windowDto.getId() == null) {
            window = windowDao.save(new Window(windowDto.getName(), windowDto.getWindowStatus(), room));
        } else {
            window = windowDao.getReferenceById(windowDto.getId());
            window.setWindowStatus(windowDto.getWindowStatus());
            window.setName(windowDto.getName());
            window.setRoom(room);
            window = windowDao.save(window);
        }
        return new WindowDto(window);
    }

}
