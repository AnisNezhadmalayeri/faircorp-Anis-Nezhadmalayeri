package com.emse.spring.faircorp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.emse.spring.faircorp.model.Room;

import java.util.List;

public interface RoomDao extends JpaRepository<Room, Long> {
    List<Room> findBybuildingId(Long building_id);

}

