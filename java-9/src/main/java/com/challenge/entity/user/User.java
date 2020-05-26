package com.challenge.entity.user;
import com.challenge.entity.candidate.Candidate;
import com.challenge.entity.submission.Submission;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @NotBlank
    @Max(100)
    private String full_name;

    @NotNull
    @NotBlank
    @Max(100)
    private String email;

    @NotNull
    @NotBlank
    @Max(50)
    private String nickname;

    @NotNull
    @NotBlank
    @Max(255)
    private String password;

    @NotNull
    @NotBlank
    private Timestamp created_at;

    @OneToMany
    private List<Candidate> candidates;

    @OneToMany
    private List<Submission> submissions;

    public User() {
    }
}
