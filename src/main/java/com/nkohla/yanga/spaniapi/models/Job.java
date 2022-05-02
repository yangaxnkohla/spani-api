package com.nkohla.yanga.spaniapi.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Job {
    @Id
    @SequenceGenerator(
            name = "job_sequence",
            sequenceName = "job_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "job_sequence"
    )
    private Long id;
    private String role;
    private String description;
    private String link;
    private LocalDate dateApplied;
    @Transient
    private String lastApplied;

    public Job() {
    }

    public Job(String role,
               String description,
               String link,
               LocalDate datePosted,
               String lastApplied) {
        this.role = role;
        this.description = description;
        this.link = link;
        this.dateApplied = datePosted;
        this.lastApplied = lastApplied;
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

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public String getLastApplied() {
        return String.valueOf(Period.between(this.dateApplied, LocalDate.now()).getMonths());
    }

    public void setLastApplied(String lastApplied) {
        this.lastApplied = lastApplied;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", dateApplied=" + dateApplied +
                ", lastApplied='" + lastApplied + '\'' +
                '}';
    }
}
