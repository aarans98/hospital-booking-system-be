package com.bahagya.miniproject.assembler;

import com.bahagya.miniproject.model.dto.ObatDto;
import com.bahagya.miniproject.model.entity.Obat;
import com.bahagya.miniproject.repository.ObatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ObatAssembler implements InterfaceAssembler<Obat, ObatDto>{
    @Autowired
    private ObatRepository repository;

    @Override
    public Obat fromDto(ObatDto dto) {
        if(dto == null)
            return null;
    
        Obat entity = new Obat();
        if(dto.getIdObat() != null){
            Optional<Obat> temp = this.repository.findById(dto.getIdObat());
            if(temp.isPresent()){
                entity = temp.get();
            }
        }

        if (dto.getIdObat() != null) entity.setIdObat(dto.getIdObat());
        if (dto.getNamaObat() != null) entity.setNamaObat(dto.getNamaObat());
        if (dto.getDeskripsi() != null) entity.setDeskripsi(dto.getDeskripsi());
        if (dto.getKategori() != null) entity.setKategori(dto.getKategori());

        return entity;
    }

    @Override
    public ObatDto fromEntity(Obat entity) {
        if (entity == null) return null;
        return ObatDto.builder()
                .idObat(entity.getIdObat())
                .namaObat(entity.getNamaObat())
                .deskripsi(entity.getDeskripsi())
                .kategori(entity.getKategori())
                .build();
    }
}
