package com.nkohla.yanga.spaniapi.services;

import com.nkohla.yanga.spaniapi.models.Job;
import com.nkohla.yanga.spaniapi.repository.SpaniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SpaniService {

    private final SpaniRepository spaniRepository;

    @Autowired
    public SpaniService(SpaniRepository spaniRepository) {
        this.spaniRepository = spaniRepository;
    }

    public List<Job> getJobs() {
        return spaniRepository.findAll();
    }

    public void addNewJob(Job job) {
        spaniRepository.save(job);
    }

    public void deleteJob(Long id) {
        spaniRepository.deleteById(id);
    }
}
