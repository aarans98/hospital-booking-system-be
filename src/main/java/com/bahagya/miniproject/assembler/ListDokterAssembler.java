package com.bahagya.miniproject.assembler;

import com.bahagya.miniproject.model.dto.ListDokterDto;
import com.bahagya.miniproject.model.entity.Praktek;
import com.bahagya.miniproject.repository.PraktekRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ListDokterAssembler implements InterfaceAssembler<Praktek, ListDokterDto> {

    @Autowired
    private PraktekRepo repository;

    @Override
    public Praktek fromDto (ListDokterDto dto){
        if (dto == null) return null;

        Praktek entity = new Praktek();
        if(dto.getIdPraktek() != null){
            Optional<Praktek> temp = this.repository.findById(dto.getIdPraktek());
            if(temp.isPresent()){
                entity = temp.get();
            }
        }

        if (dto.getIdPraktek() != null) entity.setIdPraktek(dto.getIdPraktek());
        if (dto.getJadwal() != null) entity.setJadwal(dto.getJadwal());
        if (dto.getPoli() != null) entity.setPoli(dto.getPoli());
        if (dto.getIdDokter() != null) entity.setIdDokter(dto.getIdDokter());
        if (dto.getNamaLengkap() != null) entity.setNamaLengkap(dto.getNamaLengkap());
        if (dto.getSpesialisasi() != null) entity.setSpesialisasi(dto.getSpesialisasi());

        return entity;
    }

    @Override
    public ListDokterDto fromEntity(Praktek entity){
            if(entity == null) return null;
        return ListDokterDto.builder()
                .idPraktek(entity.getIdPraktek())
                .jadwal(entity.getJadwal())
                .poli(entity.getPoli())
                .idDokter(entity.getDokter().getIdDokter())
                .namaLengkap(entity.getNamaLengkap())
                .spesialisasi(entity.getSpesialisasi())
                .build();
    }
}
