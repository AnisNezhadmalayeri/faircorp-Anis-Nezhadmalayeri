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
    private List<Heater> heater;
    private List<Window> window;


    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.current_temperature = room.getCurrent_temperature();
        this.target_temperature = room.getTarget_temperature();
        this.heater = room.getHeater();
        this.window = room.getWindow();
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

    public List<Heater> getHeater() {
        return heater;
    }
    public void setHeater(List<Heater> heater) {
        this.heater = heater;
    }

    public List<Window> getWindow() {
        return window;
    }
    public void setWindow(List<Window> window) {
        this.window = window;
    }
}
