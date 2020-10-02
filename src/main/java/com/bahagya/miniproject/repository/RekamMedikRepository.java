package com.bahagya.miniproject.repository;

import java.util.List;
import java.util.Optional;

import com.bahagya.miniproject.model.entity.RekamMedik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RekamMedikRepository extends JpaRepository<RekamMedik, Integer> {
    
    List<RekamMedik> findAllByPasienIdPasien(Integer idPasien);

    Optional<RekamMedik> findAllByJadwalDokterId(Integer idJadwal);

}
