package com.bahagya.miniproject.repository;

import java.util.List;

import com.bahagya.miniproject.model.entity.RmObat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RmObatRepository extends JpaRepository<RmObat, Integer> {

    List<RmObat> findAllByRekamMedikIdRekamMedik(Integer idRekamMedik);

    List<RmObat> findAllByObatIdObat(String idObat);

}
