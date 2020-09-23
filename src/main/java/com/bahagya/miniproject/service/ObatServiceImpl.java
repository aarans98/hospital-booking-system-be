package com.bahagya.miniproject.service;

import com.bahagya.miniproject.repository.ObatRepository;
import com.bahagya.miniproject.assembler.ObatAssembler;
import com.bahagya.miniproject.model.dto.ObatDto;
import com.bahagya.miniproject.model.entity.Obat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ObatServiceImpl implements ObatService {

    @Autowired
    private ObatRepository repository;
    @Autowired
    private ObatAssembler assembler;

    @Override
    public ObatDto insertObat(ObatDto dto) {
        Obat entity = repository.save(assembler.fromDto(dto));
        repository.save(entity);
        return assembler.fromEntity(entity);
    }
    
}