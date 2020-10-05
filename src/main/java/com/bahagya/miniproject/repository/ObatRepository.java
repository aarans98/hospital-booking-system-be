package com.bahagya.miniproject.repository;

import java.util.Optional;

import com.bahagya.miniproject.model.entity.Obat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObatRepository extends JpaRepository<Obat, String> {

    Optional<Obat> findByNamaObat(String namaObat);
    
}
