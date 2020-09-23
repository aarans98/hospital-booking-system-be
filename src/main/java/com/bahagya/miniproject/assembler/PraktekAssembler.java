package com.bahagya.miniproject.assembler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bahagya.miniproject.model.dto.PraktekDto;
import com.bahagya.miniproject.model.entity.Praktek;
import com.bahagya.miniproject.repository.PraktekRepository;


@Component
public class PraktekAssembler implements InterfaceAssembler<Praktek, PraktekDto> {
	
	@Autowired
	private PraktekRepository repository;
	
	@Override
	public Praktek fromDto(PraktekDto dto) {
		if (dto == null)
			return null;
		Praktek entity = new Praktek();
		if (dto.getIdPraktek() != null) {
            Optional<Praktek> temp = this.repository.findById(dto.getIdPraktek());
            if(temp.isPresent()){
                entity = temp.get();
            }
		}
		
		if (dto.getIdPraktek() != null) entity.setIdPraktek(dto.getIdPraktek());
		if (dto.getPoli() != null) entity.setPoli(dto.getPoli());
		if (dto.getJadwal() != null) entity.setJadwal(dto.getJadwal());
		if (dto.getIdDokter() != null) entity.setIdDokter(dto.getIdDokter());
		return entity;
	}
	
	@Override
	public PraktekDto fromEntity(Praktek entity) {
		if (entity == null) return null;
		return PraktekDto.builder()
				.idPraktek(entity.getIdPraktek())
				.poli(entity.getPoli())
				.jadwal(entity.getJadwal())
				.idDokter(entity.getDokter().getIdDokter())
				.build();
	}
	
}
