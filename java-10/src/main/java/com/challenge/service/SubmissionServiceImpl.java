package com.challenge.service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionServiceInterface {

    @Autowired
    SubmissionRepository submissionRepository;

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        BigDecimal score = submissionRepository.findHigherScoreByChallengeId(challengeId);
        if(score == null) {
            return BigDecimal.ZERO;
        }

        return score;
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return submissionRepository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    public Submission save(Submission object) {
        object.setCreatedAt(LocalDateTime.now());
        return submissionRepository.save(object);
    }
}
