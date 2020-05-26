package com.challenge.entity.candidate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
public class Candidate {

    @EmbeddedId
    private CandidateIdentity candidateIndentity;

    @NotNull
    @NotBlank
    private Integer status;

    @NotNull
    private Timestamp created_at;



}
