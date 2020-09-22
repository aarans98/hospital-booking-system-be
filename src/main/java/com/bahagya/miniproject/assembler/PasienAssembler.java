package com.bahagya.miniproject.assembler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bahagya.miniproject.model.dto.KunjunganDto;
import com.bahagya.miniproject.model.entity.Pasien;
import com.bahagya.miniproject.repository.PasienRepo;

@Component
public class PasienAssembler implements InterfaceAssembler<Pasien, KunjunganDto> {

	    @Autowired
	    private PasienRepo repository;

	    @Override
	    public Pasien fromDto(KunjunganDto dto) {
	        if (dto == null)
	            return null;

	        Pasien entity = new Pasien();
	        if (dto.getIdPasien() != null) {
	            Optional<Pasien> temp = this.repository.findById(dto.getIdPasien());
	            if(temp.isPresent()){
	                entity = temp.get();
	            }
	        }

	        if (dto.getIdPasien() != null) entity.setIdPasien(dto.getIdPasien());
	        if (dto.getNama_lengkap() != null) entity.setNama_lengkap(dto.getNama_lengkap());
	        if (dto.getTanggal_lahir() != null) entity.setTanggal_lahir(dto.getTanggal_lahir());
	        if (dto.getAlamat() != null) entity.setAlamat(dto.getAlamat());
	        if (dto.getJenis_kelamin() != null) entity.setJenis_kelamin(dto.getJenis_kelamin());
	        if (dto.getTinggi_badan() != null) entity.setTinggi_badan(dto.getTinggi_badan());
	        if (dto.getBerat_badan() != null) entity.setBerat_badan(dto.getBerat_badan());
	        if (dto.getTanggal_lahir() != null) entity.setTanggal_lahir(dto.getTanggal_lahir());
	        if (dto.getUsia() != null) entity.setUsia(dto.getUsia());

	        return entity;
	    }

	    @Override
	    public KunjunganDto fromEntity(Pasien entity) {
	        if (entity == null) return null;
	        return KunjunganDto.builder()
	                .idPasien(entity.getIdPasien())
	                .nama_lengkap(entity.getNama_lengkap())
	                .tanggal_lahir(entity.getTanggal_lahir())
	                .alamat(entity.getAlamat())
	                .jenis_kelamin(entity.getJenis_kelamin())
	                .tinggi_badan(entity.getTinggi_badan())
	                .berat_badan(entity.getBerat_badan())
	                .usia(entity.getUsia())
	                .build();
	    }

}
