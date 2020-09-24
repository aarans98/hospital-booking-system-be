package com.bahagya.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bahagya.miniproject.assembler.InformasiStafAssembler;
import com.bahagya.miniproject.model.dto.InformasiStafDto;
import com.bahagya.miniproject.model.entity.InformasiStaf;
import com.bahagya.miniproject.repository.InformasiStafRepository;

@Service
@Transactional
public class InformasiStafServiceImpl implements InformasiStafService {
	
    @Autowired
    private InformasiStafRepository repository;
    @Autowired
    private InformasiStafAssembler assembler;

    @Override
    public InformasiStafDto insertInformasiStaf(InformasiStafDto dto) {
        InformasiStaf entity = repository.save(assembler.fromDto(dto));
        repository.save(entity);
        return assembler.fromEntity(entity);
    }

}
