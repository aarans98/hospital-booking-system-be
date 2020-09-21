package com.bahagya.miniproject.repository;

import com.bahagya.miniproject.model.entity.Kota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KotaRepository extends JpaRepository<Kota, String> {

    List<Kota> findAllByProvinceKodeProvince(String codeProvince);
}
