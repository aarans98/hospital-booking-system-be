package com.bahagya.miniproject.repository;

import java.util.List;
import com.bahagya.miniproject.model.entity.RekamMedik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RekamMedikRepository extends JpaRepository<RekamMedik, Integer> {
    List<RekamMedik> findAllByPasienIdPasien(Integer idPasien);

    List<RekamMedik> findAllByDokterIdDokter(Integer idDokter);

    List<RekamMedik> findAllByPraktekIdPraktek(Integer idPraktek);

    // List<RekamMedik> findAllByObatIdObat(String idObat);

}
