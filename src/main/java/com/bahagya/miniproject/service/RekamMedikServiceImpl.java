package com.bahagya.miniproject.service;

import com.bahagya.miniproject.repository.RekamMedikRepository;
import com.bahagya.miniproject.repository.RmObatRepository;
import com.bahagya.miniproject.assembler.FormRmAssembler;
import com.bahagya.miniproject.assembler.RmObatAssembler;
import com.bahagya.miniproject.model.dto.FormRmDto;
import com.bahagya.miniproject.model.entity.RekamMedik;
import com.bahagya.miniproject.model.entity.RmObat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RekamMedikServiceImpl implements RekamMedikService {

    @Autowired
    private RekamMedikRepository repository;
    @Autowired
    private FormRmAssembler assembler;
    @Autowired
    private RmObatAssembler rmObatAssambler;
    @Autowired
    private RmObatRepository rmObatRepository;

    @Override
    public FormRmDto insertRekamMedik(FormRmDto dto) {
        RekamMedik entity = repository.save(assembler.fromDto(dto));
        repository.save(entity);
        if (!dto.getIdObat().isEmpty()){
            for(int i = 0; i < dto.getIdObat().size(); i++){
                RmObat rmObat = rmObatAssambler.toEntity(dto.getId(), dto.getIdObat().get(i));
                rmObatRepository.save(rmObat);
            }
        }
        return assembler.fromEntity(entity);
    }
    
}