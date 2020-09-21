package com.bahagya.miniproject.service;

import com.bahagya.miniproject.repository.RekamMedikRepository;
import com.bahagya.miniproject.assembler.RekamMedikAssembler;
import com.bahagya.miniproject.model.dto.RekamMedikDto;
import com.bahagya.miniproject.model.entity.RekamMedik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RekamMedikImpl implements RekamMedikService {

    @Autowired
    private RekamMedikRepository repository;
    @Autowired
    private RekamMedikAssembler assembler;

    @Override
    public RekamMedikDto insertRekamMedik(RekamMedikDto dto) {
        RekamMedik entity = repository.save(assembler.fromDto(dto));
        repository.save(entity);
        return assembler.fromEntity(entity);
    }
    
}
