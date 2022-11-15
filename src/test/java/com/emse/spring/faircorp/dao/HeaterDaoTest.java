package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Room;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.emse.spring.faircorp.model.Heater;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class HeaterDaoTest {
    @Autowired
    private HeaterDao heaterDao;
    @Test
    public void shouldFindARoom() {
        Heater heater = heaterDao.getReferenceById(-9L);
        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.OFF);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater2");
        Assertions.assertThat(heater.getPower()).isEqualTo(null);
        Assertions.assertThat(heater.getId()).isEqualTo(-9L);
    }
}