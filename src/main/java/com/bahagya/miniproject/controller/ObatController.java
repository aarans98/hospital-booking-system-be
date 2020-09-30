package com.bahagya.miniproject.controller;
import com.bahagya.miniproject.configuration.DefaultResponse;
import com.bahagya.miniproject.model.dto.ObatDto;
import com.bahagya.miniproject.model.entity.Obat;
import com.bahagya.miniproject.repository.ObatRepository;
import com.bahagya.miniproject.service.ObatService;
import com.bahagya.miniproject.assembler.ObatAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/obat")
public class ObatController {
    @Autowired
    private ObatRepository repository;
    @Autowired
    private ObatService service;
    @Autowired
    private ObatAssembler assembler;

    // http://localhost:8080/obat
    @GetMapping
    public DefaultResponse get() {
        List<Obat> ObatList = repository.findAll();
        List<ObatDto> ObatDtoList = ObatList.stream()
                .map(Obat -> assembler.fromEntity(Obat)).collect(Collectors.toList());
        return DefaultResponse.ok(ObatDtoList);
    }

    @GetMapping("/id")
    public List<String> getIdObat() {
        List<Obat> ObatList = repository.findAll();
        List<ObatDto> ObatDtoList = ObatList.stream()
                .map(Obat -> assembler.fromEntity(Obat)).collect(Collectors.toList());
        List<String> IdObatList = ObatDtoList.stream().map(Obat -> Obat.getIdObat()).collect(Collectors.toList());
        return IdObatList;
    }

    @PostMapping
    public DefaultResponse insert(@RequestBody ObatDto dto) {
        Obat Obat = assembler.fromDto(dto);
        repository.save(Obat);
        return DefaultResponse.ok(assembler.fromEntity(Obat));
    }

    @PostMapping("/trx")
    public DefaultResponse insertTrx(@RequestBody ObatDto dto) {
        return DefaultResponse.ok(service.insertObat(dto));
    }
}