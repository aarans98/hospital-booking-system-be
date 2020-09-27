package com.bahagya.miniproject.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.bahagya.miniproject.assembler.PraktekAssembler;
import com.bahagya.miniproject.configuration.DefaultResponse;
import com.bahagya.miniproject.model.dto.PraktekDto;
import com.bahagya.miniproject.model.entity.Praktek;
import com.bahagya.miniproject.repository.PraktekRepo;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/praktek")
public class PraktekController {

	@Autowired
	private PraktekRepo repository;
	@Autowired
	private PraktekAssembler assembler;

	// http://localhost:1212/praktek
	@GetMapping
	public DefaultResponse get() {
		List<Praktek> praktekList = repository.findAll();
		List<PraktekDto> praktekDtoList = praktekList.stream().map(praktek -> assembler.fromEntity(praktek))
				.collect(Collectors.toList());
		return DefaultResponse.ok(praktekDtoList);
	}
	@GetMapping
	public DefaultResponse getAll() {
		List<Praktek> praktekList = repository.findAll();
		List<PraktekDto> praktekDtoList = praktekList.stream().map(praktek -> assembler.fromEntity(praktek))
				.collect(Collectors.toList());
		return DefaultResponse.ok(praktekDtoList);
	}

	// http://localhost:1212/praktek/1
	@GetMapping("/{id_praktek}")
	public DefaultResponse get(@PathVariable Integer id_praktek) {
		PraktekDto praktekDto = assembler.fromEntity(repository.findById(id_praktek).get());
		return DefaultResponse.ok(praktekDto);
	}

	@GetMapping("/dokter/{id_dokter}")
	public DefaultResponse getByDokter(@PathVariable Integer id_dokter) {
		List<Praktek> praktekList = repository.findAllByDokterIdDokter(id_dokter);
		List<PraktekDto> praktekDtoList = praktekList.stream().map(praktek -> assembler.fromEntity(praktek))
				.collect(Collectors.toList());
		return DefaultResponse.ok(praktekDtoList);
	}

	// http://localhost:1212/praktek
	@PostMapping
	public DefaultResponse insert(@RequestBody PraktekDto dto) {
		Praktek praktek = assembler.fromDto(dto);
		repository.save(praktek);
		return DefaultResponse.ok(dto);
	}

}
