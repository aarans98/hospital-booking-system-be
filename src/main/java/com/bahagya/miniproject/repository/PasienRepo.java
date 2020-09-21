package com.bahagya.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bahagya.miniproject.model.entity.Pasien;

@Repository
public interface PasienRepo extends JpaRepository<Pasien, Integer>  {

}
