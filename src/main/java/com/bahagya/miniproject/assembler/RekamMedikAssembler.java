package com.bahagya.miniproject.assembler;

import com.bahagya.miniproject.model.dto.RekamMedikDto;
import com.bahagya.miniproject.model.entity.RekamMedik;
import com.bahagya.miniproject.repository.RekamMedikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RekamMedikAssembler implements InterfaceAssembler<RekamMedik, RekamMedikDto>{

    @Autowired
    private RekamMedikRepository repository;

    @Override
    public RekamMedik fromDto(RekamMedikDto dto) {
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
        if (dto.getIdDokter() != null) entity.setIdDokter(dto.getIdDokter());
        if (dto.getGejala() != null) entity.setGejala(dto.getGejala());
        if (dto.getIdPraktek() != null) entity.setIdPraktek(dto.getIdPasien());
        if (dto.getTanggalKunjungan() != null) entity.setTanggalKunjungan(dto.getTanggalKunjungan());
        if (dto.getTinggiBadan() != null) entity.setTinggiBadan(dto.getTinggiBadan());
        if (dto.getBeratBadan() != null) entity.setBeratBadan(dto.getBeratBadan());
        if (dto.getDiagnosa() != null) entity.setDiagnosa(dto.getDiagnosa());
        if (dto.getIdObat() != null) entity.setIdObat(dto.getIdObat());
        if (dto.getDosis() != null) entity.setDosis(dto.getDosis());

        return entity;
    }

    @Override
    public RekamMedikDto fromEntity(RekamMedik entity) {
        if (entity == null) return null;
        return RekamMedikDto.builder()
                .id(entity.getIdRekamMedik())
                .idPasien(entity.getPasien().getIdPasien())
                .idDokter(entity.getDokter().getIdDokter())
                .gejala(entity.getGejala())
                .idPraktek(entity.getPraktek().getIdPraktek())
                .tinggiBadan(entity.getTinggiBadan())
                .beratBadan(entity.getBeratBadan())
                .diagnosa(entity.getDiagnosa())
                .idObat(entity.getObat().getIdObat())
                .dosis(entity.getDosis())
                .build();
    }
    
}
