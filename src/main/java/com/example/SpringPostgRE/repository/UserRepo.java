package com.example.SpringPostgRE.repository;

import com.example.SpringPostgRE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
