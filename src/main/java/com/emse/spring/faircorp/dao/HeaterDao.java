package com.emse.spring.faircorp.dao;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import com.emse.spring.faircorp.model.Heater;

import java.util.List;

public interface HeaterDao extends JpaRepository<Heater, Long> {
    List<Heater> findByRoomId(Long room_id);
}
