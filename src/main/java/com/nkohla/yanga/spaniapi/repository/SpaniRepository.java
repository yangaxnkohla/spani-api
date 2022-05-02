package com.nkohla.yanga.spaniapi.repository;

import com.nkohla.yanga.spaniapi.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaniRepository
        extends JpaRepository<Job, Long> {
}
