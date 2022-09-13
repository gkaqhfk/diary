package com.cbnu.diary.controller;

import com.cbnu.diary.entity.UserRequest;
import com.cbnu.diary.service.SignupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("signup")
public class SignupRestController {

    private final SignupService signupService;

    @GetMapping("is-duplicated-username")
    public ResponseEntity<Boolean> isDuplicatedUsername(
            @RequestParam("username") String username) {
        log.debug("username: {}", username);
        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> create(
            @RequestPart("form") UserRequest userRequest,
            @RequestPart("file") MultipartFile file) {
        log.debug("userRequest: {}, file: {}", userRequest, file);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CREATED);
    }

    @PostMapping("individual")
    public ResponseEntity<Boolean> createIndividual(
            @RequestBody UserRequest userRequest) {
        log.debug("userRequest: {}", userRequest);
        Boolean result = signupService.createIndividual(userRequest);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("corporate")
    public ResponseEntity<Boolean> createCorporate(
            @RequestPart("form") UserRequest userRequest,
            @RequestPart("file") MultipartFile file) {
        log.debug("userRequest: {}, file: {}", userRequest, file);
        Boolean result = signupService.createCorporate(userRequest, file);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
