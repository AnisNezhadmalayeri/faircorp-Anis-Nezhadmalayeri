package com.emse.spring.faircorp.dao;
import java.util.List;
import com.emse.spring.faircorp.model.Heater;

public interface HeaterCustomDao {
    List<Heater> findBySiteText(String searchText);
}
