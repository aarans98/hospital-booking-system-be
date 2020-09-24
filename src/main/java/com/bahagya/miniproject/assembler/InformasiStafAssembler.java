package com.bahagya.miniproject.assembler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bahagya.miniproject.model.dto.InformasiStafDto;
import com.bahagya.miniproject.model.entity.InformasiStaf;
import com.bahagya.miniproject.repository.InformasiStafRepository;

@Component
public class InformasiStafAssembler implements InterfaceAssembler<InformasiStaf, InformasiStafDto> {
	
	@Autowired
	private InformasiStafRepository repository;
	
	@Override
	public InformasiStaf fromDto(InformasiStafDto dto) {
		if (dto == null)
			return null;
		InformasiStaf entity = new InformasiStaf();
		if (dto.getIdStaf() != null) {
            Optional<InformasiStaf> temp = this.repository.findById(dto.getIdStaf());
            if(temp.isPresent()){
                entity = temp.get();
            }
		}
		
		if (dto.getIdStaf() != null) entity.setIdStaf(dto.getIdStaf());
		if (dto.getNamaLengkap() != null) entity.setNamaLengkap(dto.getNamaLengkap());
		if (dto.getTanggalLahir() != null) entity.setTanggalLahir(dto.getTanggalLahir());
		if (dto.getPosisi() != null) entity.setPosisi(dto.getPosisi());
		if (dto.getMulaiBekerja() != null) entity.setMulaiBekerja(dto.getMulaiBekerja());
		if (dto.getGaji() != null) entity.setGaji(dto.getGaji());
		
		return entity;
	}
	
	@Override
	public InformasiStafDto fromEntity(InformasiStaf entity) {
		if (entity == null) return null;
		return InformasiStafDto.builder()
				.idStaf(entity.getIdStaf())
				.namaLengkap(entity.getNamaLengkap())
				.tanggalLahir(entity.getTanggalLahir())
				.posisi(entity.getPosisi())
				.mulaiBekerja(entity.getMulaiBekerja())
				.gaji(entity.getGaji())
				.build();
	}
}
