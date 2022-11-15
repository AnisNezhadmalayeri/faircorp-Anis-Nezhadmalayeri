package com.emse.spring.faircorp.model;
import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private Integer floor;
    @NonNull
    private String name;
    private Double current_temperature;
    private Double target_temperature;
    @OneToMany(mappedBy = "room")
    private List<Heater> heater;

    @OneToMany(mappedBy = "room")
    private List<Window> window;

    @ManyToOne
    private Building building;

    public Room() {
    }

    public Room(String name, Integer floor, Double current_temperature, Double target_temperature, Building building) {
        this.name = name;
        this.floor = floor;
        this.current_temperature = current_temperature;
        this.target_temperature = target_temperature;
        this.building = building;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public Integer getFloor() {
        return floor;
    }
    public void setFloor(@NonNull Integer floor) {
        this.floor = floor;
    }

    @NonNull
    public String getName() {
        return name;
    }
    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Double getCurrent_temperature() {
        return this.current_temperature;
    }
    public void setCurrent_temperature(Double Current_temperature) {
        this.current_temperature = current_temperature;
    }

    public Double getTarget_temperature() {
        return target_temperature;
    }
    public void setTarget_temperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }

    public List<Heater> getHeater() {
        return heater;
    }
//    public void setHeater(List<Heater> heater) {
//        this.heater = heater;
//    }
//
    public List<Window> getWindow() {
        return window;
    }
//    public void setWindow(List<Window> window) {
//        this.window = window;
//    }


    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
