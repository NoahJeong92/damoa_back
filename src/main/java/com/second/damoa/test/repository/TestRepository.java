package com.second.damoa.test.repository;

import com.second.damoa.test.model.Boardtest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Boardtest, Long> {
}
