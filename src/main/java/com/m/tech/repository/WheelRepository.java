package com.m.tech.repository;

import com.m.tech.model.Wheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelRepository extends JpaRepository<Wheel, Long> {
}
