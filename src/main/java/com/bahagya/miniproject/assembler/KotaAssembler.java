package com.bahagya.miniproject.assembler;

import com.bahagya.miniproject.model.dto.KotaDto;
import com.bahagya.miniproject.model.entity.Kota;
import com.bahagya.miniproject.repository.KotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KotaAssembler implements InterfaceAssembler<Kota, KotaDto> {

    @Autowired
    private KotaRepository repository;

    @Override
    public Kota fromDto(KotaDto dto) {
        if (dto == null)
            return null;

        Kota entity = new Kota();
        if (dto.getCode() != null) {
            Optional<Kota> temp = this.repository.findById(dto.getCode());
            if(temp.isPresent()){
                entity = temp.get();
            }
        }

        if (dto.getCode() != null) entity.setKodeKota(dto.getCode());
        if (dto.getName() != null) entity.setNamaKota(dto.getName());
        if (dto.getCodeProvince() != null) entity.setProvinceId(dto.getCodeProvince());

        return entity;
    }

    @Override
    public KotaDto fromEntity(Kota entity) {
        if (entity == null) return null;
        return KotaDto.builder()
                .code(entity.getKodeKota())
                .name(entity.getNamaKota())
                .codeProvince(entity.getProvince().getKodeProvince())
                .namaProvince(entity.getProvince().getNamaProvince())
                .build();
    }

}
