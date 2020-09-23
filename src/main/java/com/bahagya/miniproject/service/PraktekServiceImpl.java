package com.bahagya.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bahagya.miniproject.repository.PraktekRepository;
import com.bahagya.miniproject.assembler.PraktekAssembler;
import com.bahagya.miniproject.model.dto.PraktekDto;
import com.bahagya.miniproject.model.entity.Praktek;

@Service
@Transactional
public class PraktekServiceImpl implements PraktekService {
	
	@Autowired
	private PraktekRepository repository;
	@Autowired
	private PraktekAssembler assembler;
	
	@Override
	public PraktekDto insertPraktek(PraktekDto dto) {
		Praktek entity = repository.save(assembler.fromDto(dto));
		repository.save(entity);
		return assembler.fromEntity(entity);
		
	}
}
