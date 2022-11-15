package com.emse.spring.faircorp.dto;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.Room;

import java.util.List;

public class RoomDto {

    private Long id;
    private Integer floor;
    private String name;
    private Double current_temperature;
    private Double target_temperature;

    private Long buildingId;
    private String buildingName;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.current_temperature = room.getCurrent_temperature();
        this.target_temperature = room.getTarget_temperature();
        this.buildingId = room.getBuilding().getId();
        this.buildingName = room.getBuilding().getName();
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() {
        return this.floor;
    }
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrent_temperature() {
        return this.current_temperature;
    }
    public void setCurrent_temperature(Double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public Double getTarget_temperature() {
        return this.target_temperature;
    }
    public void setTarget_temperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
