package com.challenge.entity.submission;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
public class Submission {

    @EmbeddedId
    private SubmissionIdentity submissionsIdentity;

    @NotNull
    @Min(0)
    private Double score;

    @NotNull
    private Timestamp created_at;
}
