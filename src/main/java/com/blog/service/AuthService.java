package com.blog.service;

import com.blog.domain.Session;
import com.blog.domain.Users;
import com.blog.exception.InvalidSignInformation;
import com.blog.repository.UsersRepository;
import com.blog.request.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsersRepository usersRepository;

    @Transactional
    public String signIn(Login login) {
        Users user = usersRepository.findByEmailAndPassword(login.getEmail(), login.getPassword())
                .orElseThrow(InvalidSignInformation::new);

        Session session = user.addSession();

        return session.getAccessToken();
    }
}
