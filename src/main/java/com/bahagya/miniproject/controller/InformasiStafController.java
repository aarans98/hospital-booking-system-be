package com.bahagya.miniproject.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import com.bahagya.miniproject.model.entity.InformasiStaf;
import com.bahagya.miniproject.repository.InformasiStafRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/informasiStaf")
public class InformasiStafController {
	
	@Autowired
	private InformasiStafRepository repository;
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
	
}
