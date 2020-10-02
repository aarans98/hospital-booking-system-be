package com.bahagya.miniproject.repository;


import com.bahagya.miniproject.model.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepo extends JpaRepository<Register, String> {
//    Register findByUsername(String username);
}
