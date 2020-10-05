package com.bahagya.miniproject.assembler;

import com.bahagya.miniproject.model.dto.FormRmDto;
import com.bahagya.miniproject.model.entity.RekamMedik;
import com.bahagya.miniproject.model.entity.RmObat;
import com.bahagya.miniproject.repository.ObatRepository;
import com.bahagya.miniproject.repository.RekamMedikRepository;
import com.bahagya.miniproject.repository.RmObatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FormRmAssembler implements InterfaceAssembler<RekamMedik, FormRmDto>{

    @Autowired
    private RekamMedikRepository repository;

    @Autowired
    private ObatRepository obatRepository;

    @Autowired
    private RmObatRepository rmObatRepository;

    @Override
    public RekamMedik fromDto(FormRmDto dto) {
        if(dto == null)
            return null;
    
        RekamMedik entity = new RekamMedik();
        if(dto.getId() != null){
            Optional<RekamMedik> temp = this.repository.findById(dto.getId());
            if(temp.isPresent()){
                entity = temp.get();
            }
        }

        if (dto.getId() != null) entity.setIdRekamMedik(dto.getId());
        if (dto.getIdPasien() != null) entity.setIdPasien(dto.getIdPasien());
        if (dto.getGejala() != null) entity.setGejala(dto.getGejala());
        if (dto.getIdJadwal() != null) entity.setIdJadwal(dto.getIdJadwal());
        if (dto.getTinggiBadan() != null) entity.setTinggiBadan(dto.getTinggiBadan());
        if (dto.getBeratBadan() != null) entity.setBeratBadan(dto.getBeratBadan());
        if (dto.getDiagnosa() != null) entity.setDiagnosa(dto.getDiagnosa());
        if (dto.getDosis() != null) entity.setDosis(dto.getDosis());

        return entity;
    }

    @Override
    public FormRmDto fromEntity(RekamMedik entity) {
        if (entity == null) return null;
        List<RmObat> rmObat = rmObatRepository.findAllByRekamMedikIdRekamMedik(entity.getIdRekamMedik());
        List<String> obatNama = new ArrayList<>();
        if(!rmObat.isEmpty()){
            obatNama = rmObat.stream().map(obat -> obat.getObat().getNamaObat()).collect(Collectors.toList());
        }
        return FormRmDto.builder()
                .id(entity.getIdRekamMedik())
                .idPasien(entity.getIdPasien())
                .tinggiBadan(entity.getTinggiBadan())
                .beratBadan(entity.getBeratBadan())
                .gejala(entity.getGejala())
                .diagnosa(entity.getDiagnosa())
                .idJadwal(entity.getIdJadwal())
                .namaObat(obatNama)
                .dosis(entity.getDosis())
                .build();
    }
    
}
