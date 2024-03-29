package com.berk.first.repo;


import com.berk.first.model.UserDataBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepo extends JpaRepository<UserDataBase, UUID> {
    UserDataBase findByEmail(String test);

    List<UserDataBase> findByName(String isActive);
    List<UserDataBase> findByRowId(UUID rowId);
}
