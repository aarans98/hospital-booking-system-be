package com.bahagya.miniproject.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bahagya.miniproject.assembler.PasienAssembler;
import com.bahagya.miniproject.configuration.DefaultResponse;
import com.bahagya.miniproject.model.dto.KunjunganDto;
import com.bahagya.miniproject.model.entity.JadwalDokter;
import com.bahagya.miniproject.model.entity.Pasien;
import com.bahagya.miniproject.repository.JadwalDokterRepo;
import com.bahagya.miniproject.repository.PasienRepo;

@RestController
@RequestMapping("/pasien")
public class PasienController {
	
	    @Autowired
	    private PasienRepo repository;
	    @Autowired
	    private JadwalDokterRepo repositori;
	    @Autowired
	    private PasienAssembler assembler;

	    // http://localhost:8080/pasien
	    @GetMapping
	    public DefaultResponse get() {
	        List<Pasien> pasienList = repository.findAll();
	        List<KunjunganDto> kunjunganDtoList = pasienList.stream().map(patient -> assembler.fromEntity(patient))
	                .collect(Collectors.toList());
	        return DefaultResponse.ok(kunjunganDtoList);
	    }

	    // http://localhost:8080/province/33
	    @GetMapping("/{id_pasien}")
	    public DefaultResponse get(@PathVariable Integer id_pasien) {
	        KunjunganDto kunjunganDto = assembler.fromEntity(repository.findById(id_pasien).get());
	        return DefaultResponse.ok(kunjunganDto);
	    }

	    /*Insert Data*/
	    @PostMapping
	    public DefaultResponse insert(@RequestBody KunjunganDto dto) {
	        Pasien pasien = assembler.fromDto(dto);
	        repository.save(pasien);
	        JadwalDokter jd=new JadwalDokter();
	        jd.setIdDokter(dto.getIdDokter());
	        jd.setIdPraktek(dto.getIdPraktek());
	        jd.setNama_lengkap(dto.getNama_lengkap());
	        repositori.save(jd);
	        return DefaultResponse.ok(dto);
	    }
}
