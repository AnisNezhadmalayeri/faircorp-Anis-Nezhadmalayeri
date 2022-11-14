package com.emse.spring.faircorp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface WindowDao extends JpaRepository<Window, Long> {
    List<Window> findByRoomId(Long room_id);
}
