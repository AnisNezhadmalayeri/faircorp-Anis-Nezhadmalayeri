package com.emse.spring.faircorp.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Heater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private HeaterStatus heaterStatus;
    private Integer power;
    @ManyToOne
    private Room room;

    public Heater() {
    }

    public Heater(String name, HeaterStatus heaterStatus, Integer power, Room room) {
        this.name = name;
        this.heaterStatus = heaterStatus;
        this.power = power;
        this.room = room;
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

    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
}
