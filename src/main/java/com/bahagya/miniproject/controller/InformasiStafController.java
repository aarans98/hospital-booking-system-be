package com.bahagya.miniproject.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.bahagya.miniproject.model.entity.Dokter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bahagya.miniproject.assembler.InformasiStafAssembler;
import com.bahagya.miniproject.configuration.DefaultResponse;
import com.bahagya.miniproject.model.dto.InformasiStafDto;
import com.bahagya.miniproject.model.dto.JumlahDto;
import com.bahagya.miniproject.model.entity.InformasiStaf;
import com.bahagya.miniproject.repository.InformasiStafRepository;
import com.bahagya.miniproject.repository.DokterRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/informasiStaf")
public class InformasiStafController {
	
	@Autowired
	private InformasiStafRepository repository;
	@Autowired
	private DokterRepo dokterRepository;
	@Autowired
	private InformasiStafAssembler assembler;
	
	// http://localhost:1212/informasiStaf
	@GetMapping
	public DefaultResponse get() {
		List<InformasiStaf> informasiStafList = repository.findAll();
		List<InformasiStafDto> informasiStafDtoList = informasiStafList.stream().map(informasiStaf -> assembler.fromEntity(informasiStaf))
				.collect(Collectors.toList());
		return DefaultResponse.ok(informasiStafDtoList);
	}
	
	// http://localhost:1212/informasiStaf/1
	@GetMapping("/{id_staf}")
	public DefaultResponse get(@PathVariable Integer id_staf) {
		InformasiStafDto informasiStafDto = assembler.fromEntity(repository.findById(id_staf).get());
		return DefaultResponse.ok(informasiStafDto);
	}
	
	/*Insert Data*/
	@PostMapping
	public DefaultResponse insert(@RequestBody InformasiStafDto dto) {
		InformasiStaf informasiStaf = assembler.fromDto(dto);
		repository.save(informasiStaf);
		return DefaultResponse.ok(dto);
	}
	
	/*Delete Data*/
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		repository.deleteById(id);
	}

	@GetMapping("/jumlahstaf")
	public JumlahDto getJumlahStaf() {
		List<InformasiStaf> informasiStafList = repository.findAll();
		JumlahDto dto = new JumlahDto();
		int j  = 0;
		for (int i=0; i < informasiStafList.size(); i++) {
			j++;
		}
		dto.setJumlah(j);
		return dto;
	}

	@GetMapping("/jumlahdokter")
	public JumlahDto getJumlahDokter() {
		List<Dokter> dokterList = dokterRepository.findAll();
		JumlahDto dto = new JumlahDto();
		int j  = 0;
		for (int i=0; i < dokterList.size(); i++) {
			j++;
		}
		dto.setJumlah(j);
		return dto;
	}

}
