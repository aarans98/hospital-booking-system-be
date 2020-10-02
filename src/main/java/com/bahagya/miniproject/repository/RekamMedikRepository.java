package com.bahagya.miniproject.repository;

import java.util.Optional;

import com.bahagya.miniproject.model.entity.RekamMedik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RekamMedikRepository extends JpaRepository<RekamMedik, Integer> {

    Optional<RekamMedik> findAllByJadwalDokterId(Integer idJadwal);

}
