package com.team17.desking.repository;

import com.team17.desking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
