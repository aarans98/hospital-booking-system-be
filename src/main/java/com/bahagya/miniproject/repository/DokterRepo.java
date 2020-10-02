package com.bahagya.miniproject.repository;

import com.bahagya.miniproject.model.entity.Dokter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DokterRepo extends JpaRepository<Dokter, Integer> {
	List<Dokter> findByUsername(String username);
}
