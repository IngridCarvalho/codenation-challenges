package com.challenge.entity.candidate;

import com.challenge.entity.company.Company;
import com.challenge.entity.user.User;
import com.challenge.entity.acceleration.Acceleration;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class CandidateIdentity implements Serializable {

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private Acceleration acceleration;

    @ManyToOne
    @NotNull
    private Company company;
}
