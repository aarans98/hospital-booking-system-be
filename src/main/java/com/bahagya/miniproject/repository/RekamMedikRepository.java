package com.bahagya.miniproject.repository;

import com.bahagya.miniproject.model.entity.RekamMedik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RekamMedikRepository extends JpaRepository<RekamMedik, Integer> {
    List<RekamMedik> findAllByPasienIdPasien(Integer idPasienInteger);

    List<RekamMedik> findAllByPasienIdDokter(Integer idDokInteger);

    List<RekamMedik> findAllByPasienIdPrakter(Integer idPrakInteger);

    List<RekamMedik> findAllByPasienIdObat(Integer idObaInteger);

}
s