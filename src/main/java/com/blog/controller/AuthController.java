package com.blog.controller;

import com.blog.repository.UsersRepository;
import com.blog.request.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UsersRepository usersRepository;

    @PostMapping("/auth/login")
    public void login(@RequestBody Login login) {
        // json
        log.info(">>>login={}", login);

        // DB에서 조회
    }
}
