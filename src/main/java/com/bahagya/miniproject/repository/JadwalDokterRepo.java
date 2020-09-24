package com.bahagya.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bahagya.miniproject.model.entity.JadwalDokter;

@Repository
public interface JadwalDokterRepo extends JpaRepository<JadwalDokter, Integer> {

}
