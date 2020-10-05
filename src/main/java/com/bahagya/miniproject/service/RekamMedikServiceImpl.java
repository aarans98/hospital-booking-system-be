package com.bahagya.miniproject.service;

import com.bahagya.miniproject.repository.RekamMedikRepository;
import com.bahagya.miniproject.repository.RmObatRepository;
import com.bahagya.miniproject.repository.ObatRepository;
import com.bahagya.miniproject.assembler.FormRmAssembler;
import com.bahagya.miniproject.assembler.RmObatAssembler;
import com.bahagya.miniproject.model.dto.FormRmDto;
import com.bahagya.miniproject.model.entity.RekamMedik;
import com.bahagya.miniproject.model.entity.RmObat;
import com.bahagya.miniproject.model.entity.Obat;

import java.util.List;

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
    @Autowired
    private ObatRepository obatRepository;

    @Override
    public FormRmDto insertRekamMedik(FormRmDto dto) {
        RekamMedik entity = repository.save(assembler.fromDto(dto));
        repository.save(entity);
        if (!dto.getNamaObat().isEmpty()) {
            List<RmObat> temp = rmObatRepository.findAllByRekamMedikIdRekamMedik(dto.getId());
            if (!temp.isEmpty()) {
                for (int i = 0; i < temp.size(); i++) {
                    rmObatRepository.deleteById(temp.get(i).getIdRmObat());
                }
            }
            for (int i = 0; i < dto.getNamaObat().size(); i++) {
                Obat obat = obatRepository.findByNamaObat(dto.getNamaObat().get(i)).get();
                RmObat rmObat = rmObatAssambler.toEntity(dto.getId(), obat.getIdObat());
                rmObatRepository.save(rmObat);
            }
        }
        return assembler.fromEntity(entity);
    }
    
}