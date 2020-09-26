package com.bahagya.miniproject.assembler;

import com.bahagya.miniproject.model.dto.ListDokterDto;
import com.bahagya.miniproject.model.entity.Dokter;
import com.bahagya.miniproject.model.entity.Praktek;
import com.bahagya.miniproject.repository.DokterRepo;
import com.bahagya.miniproject.repository.PraktekRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ListDokterAssembler implements InterfaceAssembler<Dokter, ListDokterDto> {

    @Autowired
    private DokterRepo repository;

    @Override
    public Dokter fromDto (ListDokterDto dto){
        if (dto == null) return null;

        Dokter entity = new Dokter();
        if(dto.getIdDokter() != null){
            Optional<Dokter> temp = this.repository.findById(dto.getIdDokter());
            if(temp.isPresent()){
                entity = temp.get();
            }
        }

        if (dto.getIdDokter() != null) entity.setIdDokter(dto.getIdDokter());
        if (dto.getUsername() != null) entity.setUsername(dto.getUsername());
        if (dto.getNamaLengkap() != null) entity.setNamaLengkap(dto.getNamaLengkap());
        if (dto.getSpesialisasi() != null) entity.setSpesialisasi(dto.getSpesialisasi());
        if (dto.getTanggalLahir() != null) entity.setTanggalLahir(dto.getTanggalLahir());

        return entity;
    }

    @Override
    public ListDokterDto fromEntity(Dokter entity){
            if(entity == null) return null;
        return ListDokterDto.builder()
                .idDokter(entity.getIdDokter())
                .username(entity.getUsername())
                .namaLengkap(entity.getNamaLengkap())
                .spesialisasi(entity.getSpesialisasi())
                .tanggalLahir(entity.getTanggalLahir())
                .build();
    }
}
