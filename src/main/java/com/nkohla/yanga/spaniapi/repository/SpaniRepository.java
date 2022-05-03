package com.nkohla.yanga.spaniapi.repository;

import com.nkohla.yanga.spaniapi.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpaniRepository extends JpaRepository<Job, Long> {

    @Query("SELECT j FROM Job j WHERE j.link = ?1")
    Optional<Job> findJobByLink(String link);
}
