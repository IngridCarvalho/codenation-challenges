package com.challenge.entity.submission;

import com.challenge.entity.user.User;
import com.challenge.entity.challenge.Challenge;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class SubmissionIdentity implements Serializable {

    @ManyToOne
    private User user;

    @ManyToOne
    private Challenge challenge;
}
