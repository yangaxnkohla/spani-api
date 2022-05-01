package com.nkohla.yanga.spaniapi.models;

import java.time.LocalDate;

public class Job {
    private Long id;
    private String role;
    private String description;
    private String link;
    private LocalDate datePosted;

    public Job(String role, String description, String link, LocalDate datePosted) {
        this.role = role;
        this.description = description;
        this.link = link;
        this.datePosted = datePosted;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    @Override
    public String toString() {
        return "Job{" +
                "role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", datePosted=" + datePosted +
                '}';
    }
}
