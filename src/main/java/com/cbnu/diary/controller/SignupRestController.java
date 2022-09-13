package com.cbnu.diary.controller;

import com.cbnu.diary.entity.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@Slf4j
@RestController
@RequestMapping("signup")
public class SignupRestController {

    @GetMapping("is-duplicated-username")
    public ResponseEntity<Boolean> isDuplicatedUsername(
            @RequestParam("username") String username) {
        log.debug("username: {}", username);
        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> create(
            @RequestBody UserRequest userRequest) {
        log.debug("userRequest: {}", userRequest);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CREATED);
    }

}
