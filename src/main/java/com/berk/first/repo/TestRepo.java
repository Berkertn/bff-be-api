package com.berk.first.repo;


import com.berk.first.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TestRepo extends JpaRepository<Test, UUID> {
    Test findByTest(String test);

    List<Test> findByIsActive(String isActive);
}
