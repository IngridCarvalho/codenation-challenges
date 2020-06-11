package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<User> findByAccelerationNameOrCompanyId(@RequestParam(required = false) String accelerationName,
                                                                        @RequestParam(required = false) Long companyId) {
        List<User> users = new ArrayList<>();
        if (accelerationName != null) {
            users = this.userService.findByAccelerationName(accelerationName);
        }
        if (companyId != null) {
            users = this.userService.findByCompanyId(companyId);
        }

        return users;
    }

}
