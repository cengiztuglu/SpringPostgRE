package com.example.SpringPostgRE.repository;

import com.example.SpringPostgRE.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepo extends JpaRepository<Adress,Long> {
}
