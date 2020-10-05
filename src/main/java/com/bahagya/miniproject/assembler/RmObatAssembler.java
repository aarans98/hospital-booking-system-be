package com.bahagya.miniproject.assembler;

import com.bahagya.miniproject.model.entity.Obat;
import com.bahagya.miniproject.model.entity.RekamMedik;
import com.bahagya.miniproject.model.entity.RmObat;
import com.bahagya.miniproject.repository.ObatRepository;
import com.bahagya.miniproject.repository.RekamMedikRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RmObatAssembler {

    // @Autowired
    // private RmObatRepository repository;

    @Autowired
    private RekamMedikRepository rmRepository;

    @Autowired
    private ObatRepository obatRepository;

    public RmObat toEntity(Integer idRekamMedik, String idObat) {

        RmObat entity = new RmObat();
        if (idRekamMedik != null && idObat != null) {
            RekamMedik rekamMedik = rmRepository.findById(idRekamMedik).get();
            entity.setRekamMedik(rekamMedik);
            Obat obat = obatRepository.findById(idObat).get();
            entity.setObat(obat);
        }
        return entity;
    }

}