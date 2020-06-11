package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    private SubmissionService submissionService;

    @Autowired
    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    private SubmissionMapper submissionMapper = Mappers.getMapper(SubmissionMapper.class);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<SubmissionDTO> findAll(@RequestParam(required = false) Long challengeId,
                                       @RequestParam(required = false) Long accelerationId) {
        List<SubmissionDTO> submissions = null;
        
        if(challengeId != null && accelerationId != null) {
            submissions = submissionMapper.map(submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
        }
        return submissions;
    }
}
