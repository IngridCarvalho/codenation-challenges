package com.challenge.entity.challenge;

import com.challenge.entity.submission.Submission;
import com.challenge.entity.acceleration.Acceleration;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @NotBlank
    @Max(100)
    private String name;

    @NotNull
    @NotBlank
    @Max(50)
    private String slug;

    @NotNull
    @NotBlank
    private Timestamp created_at;

    @OneToMany
    private List<Acceleration> accelerations;

    @OneToMany
    private List<Submission> submissions;
}
