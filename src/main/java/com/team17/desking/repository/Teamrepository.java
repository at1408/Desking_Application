package com.team17.desking.repository;

import com.team17.desking.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Teamrepository extends JpaRepository<Team,Long> {
}
