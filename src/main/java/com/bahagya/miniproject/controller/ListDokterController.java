package com.bahagya.miniproject.controller;

import com.bahagya.miniproject.assembler.ListDokterAssembler;
import com.bahagya.miniproject.configuration.DefaultResponse;
import com.bahagya.miniproject.model.dto.ListDokterDto;
import com.bahagya.miniproject.model.entity.Dokter;
import com.bahagya.miniproject.model.entity.Praktek;
import com.bahagya.miniproject.repository.DokterRepo;
import com.bahagya.miniproject.repository.PraktekRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/dokter")
public class ListDokterController {

    @Autowired
    private DokterRepo repository;
    @Autowired
    private ListDokterAssembler assembler;

    @GetMapping
    public DefaultResponse get() {
        List<Dokter> praktekList = repository.findAll();
        List<ListDokterDto> listDokterDto = praktekList.stream().map(dokter -> assembler.fromEntity(dokter))
                .collect(Collectors.toList());
        return DefaultResponse.ok(listDokterDto);
    }

    @GetMapping("/{id}")
    public DefaultResponse get(@PathVariable Integer id) {
        ListDokterDto listDokterDto = assembler.fromEntity(repository.findById(id).get());
        return DefaultResponse.ok(listDokterDto);
    }

    @PostMapping
    public DefaultResponse insert(@RequestBody ListDokterDto dto) {
//    	if(repository.findByUsername(dto.getUsername()).isEmpty()){
        Dokter dokter = assembler.fromDto(dto);
        repository.save(dokter);
        return DefaultResponse.ok(dto);
//    	}
//    	return DefaultResponse.error("Username sudah digunakan");
    	//usernamme belum terdaftar belom bisa
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }


}
