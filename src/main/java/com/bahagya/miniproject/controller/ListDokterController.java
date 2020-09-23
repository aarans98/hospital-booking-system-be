package com.bahagya.miniproject.controller;

import com.bahagya.miniproject.assembler.ListDokterAssembler;
import com.bahagya.miniproject.configuration.DefaultResponse;
import com.bahagya.miniproject.model.dto.ListDokterDto;
import com.bahagya.miniproject.model.entity.Praktek;
import com.bahagya.miniproject.repository.PraktekRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dokter")
public class ListDokterController {

    @Autowired
    private PraktekRepo repository;
    @Autowired
    private ListDokterAssembler assembler;

    @GetMapping
    public DefaultResponse get(){
        List<Praktek> praktekList = repository.findAll();
        List<ListDokterDto> listDokterDto = praktekList.stream()
                .map(praktek -> assembler.fromEntity(praktek))
                .collect(Collectors.toList());
        return DefaultResponse.ok(listDokterDto);
    }
    @PostMapping
    public DefaultResponse insert(@RequestBody ListDokterDto dto) {
        Praktek praktek = assembler.fromDto(dto);
        repository.save(praktek);
        return DefaultResponse.ok(assembler.fromEntity(praktek));
    }

}