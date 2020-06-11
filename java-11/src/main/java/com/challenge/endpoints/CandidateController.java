package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    private CandidateMapper candidateMapper = Mappers.getMapper(CandidateMapper.class);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public CandidateDTO findById(@PathVariable("userId") Long userId,
                                  @PathVariable("companyId") Long companyId,
                                  @PathVariable("accelerationId") Long accelerationId) {

        return candidateService.findById(userId, companyId, accelerationId).map(c -> candidateMapper.map(c)).orElse(new CandidateDTO());
    }

    @GetMapping
    public List<CandidateDTO> findByCompanyIdOrAccelerationId(@RequestParam(required = false) Long companyId,
                                                              @RequestParam(required = false) Long accelerationId) {
        List<CandidateDTO> candidates = new ArrayList<>();

        if (companyId != null) {
            candidates = candidateMapper.map(this.candidateService.findByCompanyId(companyId));
        }
        if (accelerationId != null) {
            candidates = candidateMapper.map(this.candidateService.findByAccelerationId(accelerationId));
        }
        return candidates;
    }
}
