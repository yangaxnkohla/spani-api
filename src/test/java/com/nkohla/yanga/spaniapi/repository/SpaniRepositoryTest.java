package com.nkohla.yanga.spaniapi.repository;

import com.nkohla.yanga.spaniapi.models.Job;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@ContextConfiguration(classes = {SpaniApiApplication.class})
@DataJpaTest
class SpaniRepositoryTest {

    @Autowired
    private SpaniRepository spaniRepository;

    @AfterEach
    void tearDown() {
        spaniRepository.deleteAll();;
    }

    @Test
    void shouldFindJobByLink() {
        // given
        Job job = new Job(
                "Life Engineer",
                "Do magical things.",
                "http://localhost",
                LocalDate.now(),
                "10 months ago"
        );
        spaniRepository.save(job);

        // when
        boolean result = spaniRepository.findJobByLink("http://localhost").isPresent();

        // then
        assertThat(result).isTrue();
    }

    @Test
    void shouldCheckJobByLinkDoesNotExist() {
        // given
        String link = "http://localhost";

        // when
        boolean result = spaniRepository.findJobByLink(link).isPresent();

        // then
        assertThat(result).isFalse();
    }
}