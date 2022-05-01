package com.nkohla.yanga.spaniapi.controllers;

import com.nkohla.yanga.spaniapi.models.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/jobs")
public class SpaniController {

    // Create Jobs


    // Get Jobs
    @GetMapping
    public List<Job> getJobs() {
        return List.of(
                new Job("role",
                        "description",
                        "link",
                        LocalDate.of(2022, 5, 1))
        );
    }


    // Update Jobs


    // Delete Jobs
}
