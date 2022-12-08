package com.blog.repository;

import com.blog.domain.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users, Long> {

    Optional<Users> findByEmailAndPassword(String email, String password);
}
