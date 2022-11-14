package com.emse.spring.faircorp.dto;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;

public class HeaterDto {

    private Long id;
    private String name;
    private HeaterStatus heaterStatus;
    private Integer power;
    private Long roomId;
    private String roomName;

    public HeaterDto() {
    }

    public HeaterDto(Heater heater) {
        this.id = heater.getId();
        this.name = heater.getName();
        this.heaterStatus = heater.getHeaterStatus();
        this.power = heater.getPower();
        this.roomId = heater.getRoom().getId();
        this.roomName = heater.getRoom().getName();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }
    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

    public Integer getPower() {
        return power;
    }
    public void setPower(Integer power) {
        this.power = power;
    }

    public Long getRoomId() {
        return roomId;
    }
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

}
