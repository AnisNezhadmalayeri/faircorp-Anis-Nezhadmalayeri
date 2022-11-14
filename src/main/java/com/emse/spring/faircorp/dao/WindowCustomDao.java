package com.emse.spring.faircorp.dao;
import java.util.List;
import com.emse.spring.faircorp.model.Window;

public interface WindowCustomDao {
    List<Window> findBySiteText(String searchText);

}
