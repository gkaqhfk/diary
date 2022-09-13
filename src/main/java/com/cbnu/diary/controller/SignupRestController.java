package com.cbnu.diary.controller;

import com.cbnu.diary.entity.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
            @RequestPart("form") UserRequest userRequest,
            @RequestPart("file") MultipartFile file) {
        log.debug("userRequest: {}, file: {}", userRequest, file);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CREATED);
    }

}
