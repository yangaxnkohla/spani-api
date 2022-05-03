package com.nkohla.yanga.spaniapi.controllers;

import com.nkohla.yanga.spaniapi.models.Job;
import com.nkohla.yanga.spaniapi.services.SpaniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/jobs")
public class SpaniController {

    private final SpaniService spaniService;

    @Autowired
    public SpaniController(SpaniService spaniService) {
        this.spaniService = spaniService;
    }

    // Create Jobs
    @PostMapping
    public void addNewJob(@RequestBody Job job) {
        spaniService.addNewJob(job);
    }

    // Get Jobs
    @GetMapping
    public List<Job> getJobs() {
        return spaniService.getJobs();
    }

    // Update Jobs
    @PutMapping(path="{id}")
    public void updateJob(@PathVariable("id") Long id,
                          @RequestParam(required = false) String role,
                          @RequestParam(required = false) String description,
                          @RequestParam(required = false) String link,
                          @RequestParam(required = false) String dateApplied) {
        spaniService.updateJob(id, role, description, link, dateApplied);
    }

    // Delete Jobs
    @DeleteMapping(path="{id}")
    public void deleteJob(@PathVariable("id") Long id) {
        spaniService.deleteJob(id);
    }
}
