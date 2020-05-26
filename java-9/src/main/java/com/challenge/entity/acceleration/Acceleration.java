package com.challenge.entity.acceleration;

import com.challenge.entity.candidate.Candidate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Acceleration {

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
    private Timestamp created_at;

    @OneToMany
    private List<Candidate> candidates;
}
