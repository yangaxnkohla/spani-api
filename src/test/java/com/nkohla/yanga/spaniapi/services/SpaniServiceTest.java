package com.nkohla.yanga.spaniapi.services;

import com.nkohla.yanga.spaniapi.models.Job;
import com.nkohla.yanga.spaniapi.repository.SpaniRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@DataJpaTest
class SpaniServiceTest {

    @Autowired
    private SpaniRepository spaniRepository;
    private SpaniService spaniService;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        spaniService = new SpaniService(spaniRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getJobs() {
        // given
        spaniService.getJobs();

        // when

        // then
        verify(spaniRepository).findAll();
    }

    @Test
    void addNewJob() {
    }

    @Test
    void deleteJob() {
    }

    @Test
    void updateJob() {
    }
}