package com.nkohla.yanga.spaniapi.services;

import com.nkohla.yanga.spaniapi.models.Job;
import com.nkohla.yanga.spaniapi.repository.SpaniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Optional<Job> jobOptional = spaniRepository.findJobByLink(job.getLink());
        if (jobOptional.isPresent()) {
            throw new IllegalStateException("Job with the link '"+job.getLink()+"' already exists");
        }
        spaniRepository.save(job);
    }

    public void deleteJob(Long id) {
        boolean jobExists = spaniRepository.existsById(id);
        if (!jobExists) {
            throw new IllegalStateException("Job with the id '"+id+"' does not exist");
        }
        spaniRepository.deleteById(id);
    }

    @Transactional
    public void updateJob(Long id, String role, String description, String link, String dateApplied) {
        Job job = spaniRepository.findById(id).orElseThrow(() -> new IllegalStateException("Job with id '"+id+"' does not exist"));

        if (role != null && role.length() > 0 && !Objects.equals(job.getRole(), role)) {
            job.setRole(role);
        }

        if (description != null && description.length() > 0 && !Objects.equals(job.getDescription(), description)) {
            job.setDescription(description);
        }

        if (link != null && link.length() > 0 && !Objects.equals(job.getLink(), link)) {
            job.setLink(link);
        }

        if (dateApplied != null && dateApplied.length() > 0) {
            job.setDateApplied(LocalDate.of(
                    Integer.parseInt(dateApplied.split("-")[0]),
                    Integer.parseInt(dateApplied.split("-")[1]),
                    Integer.parseInt(dateApplied.split("-")[2])));
        }
    }
}
