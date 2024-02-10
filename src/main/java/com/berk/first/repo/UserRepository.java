package com.berk.first.repo;


import com.berk.first.entities.UserDataBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserDataBase, UUID> {
    Optional<UserDataBase> findByEmail(String test);

    List<UserDataBase> findByName(String isActive);
    List<UserDataBase> findByRowId(UUID rowId);
}
