package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    Optional<Acceleration> findById(@PathVariable("id") Long id) {
        return accelerationService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(params = "companyId")
    List<Acceleration> findByCompanyId(@RequestParam("companyId") Long companyId) {
        return accelerationService.findByCompanyId(companyId);
    }
}
