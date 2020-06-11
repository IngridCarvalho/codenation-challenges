package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    Optional<Company> findById(@PathVariable("id") Long id) {
        return companyService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(params = "accelerationId")
    List<Company> findByAccelerationId(@RequestParam("accelerationId") Long accelerationId) {
        return companyService.findByAccelerationId(accelerationId);
    }

    @GetMapping(params = "userId")
    List<Company> findByUserId(@RequestParam("userId") Long userId) {
        return companyService.findByUserId(userId);
    }
}
