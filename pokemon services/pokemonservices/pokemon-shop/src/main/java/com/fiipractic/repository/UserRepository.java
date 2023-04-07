package com.fiipractic.repository;

import com.fiipractic.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {
    AppUser findAppUserByUsername(String username);
}
