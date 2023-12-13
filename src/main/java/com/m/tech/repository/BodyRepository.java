package com.m.tech.repository;

import com.m.tech.model.Body;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyRepository extends JpaRepository<Body, Long> {
}
