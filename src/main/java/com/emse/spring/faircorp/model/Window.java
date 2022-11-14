package com.emse.spring.faircorp.model;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "RWINDOW")
public class Window {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @ManyToOne
    private Room room;

    private WindowStatus windowStatus;

    public Window() {
    }

    public Window(String name, WindowStatus windowStatus, Room room) {
        this.windowStatus = windowStatus;
        this.name = name;
        this.room = room;
    }

    public Long getId() {
        return this.id;
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

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }
    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
}