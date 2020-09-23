package com.bahagya.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bahagya.miniproject.assembler.PasienAssembler;
import com.bahagya.miniproject.model.dto.KunjunganDto;
import com.bahagya.miniproject.model.entity.JadwalDokter;
import com.bahagya.miniproject.model.entity.Pasien;
import com.bahagya.miniproject.repository.JadwalDokterRepo;
import com.bahagya.miniproject.repository.PasienRepo;

@Service
@Transactional
public class PasienServiceImpl implements PasienService {
	
	    @Autowired
	    private PasienRepo repository;
	    @Autowired
	    private JadwalDokterRepo repositori;
	    @Autowired
	    private PasienAssembler assembler;

	    @Override
	    public KunjunganDto insertFormKunjungan(KunjunganDto dto) {
	        Pasien entity = repository.save(assembler.fromDto(dto));
	        repository.save(entity); 
	        return assembler.fromEntity(entity);
	    }
	    
	}
