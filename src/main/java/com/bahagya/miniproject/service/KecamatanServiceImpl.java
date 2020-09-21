package com.bahagya.miniproject.service;

import com.bahagya.miniproject.repository.KecamatanRepository;
import com.bahagya.miniproject.assembler.KecamatanAssembler;
import com.bahagya.miniproject.model.dto.KecamatanDto;
import com.bahagya.miniproject.model.entity.Kecamatan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KecamatanServiceImpl implements KecamatanService{
    @Autowired
    private KecamatanRepository repository;
    @Autowired
    private KecamatanAssembler assembler;

    @Override
    public KecamatanDto insertDataKecamatan(KecamatanDto dto) {
        Kecamatan entity = repository.save(assembler.fromDto(dto));
        repository.save(entity);
        return assembler.fromEntity(entity);
    }
}
