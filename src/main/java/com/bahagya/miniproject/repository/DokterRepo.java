package com.bahagya.miniproject.repository;

import com.bahagya.miniproject.model.entity.Dokter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DokterRepo extends JpaRepository<Dokter, String> {

}
