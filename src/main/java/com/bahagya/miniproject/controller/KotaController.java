package com.bahagya.miniproject.controller;

import com.bahagya.miniproject.configuration.DefaultResponse;
import com.bahagya.miniproject.model.dto.KotaDto;
import com.bahagya.miniproject.model.entity.Kota;
import com.bahagya.miniproject.repository.KotaRepository;
import com.bahagya.miniproject.assembler.KotaAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/kota")
public class KotaController {
    @Autowired
    private KotaRepository repository;
    @Autowired
    private KotaAssembler assembler;

    // http://localhost:8080/kota
    @GetMapping
    public DefaultResponse get() {
        List<Kota> kotaList = repository.findAll();
        List<KotaDto> kotaDtoList = kotaList.stream().map(kota -> assembler.fromEntity(kota))
                .collect(Collectors.toList());
        return DefaultResponse.ok(kotaDtoList);
    }

    // http://localhost:8080/kota/3303
    @GetMapping("/{code}")
    public DefaultResponse get(@PathVariable String code) {
        KotaDto kotaDto = assembler.fromEntity(repository.findById(code).get());
        return DefaultResponse.ok(kotaDto);
    }

    @GetMapping("/prov/{codeProvince}")
    public DefaultResponse getByProvince(@PathVariable String codeProvince) {
        List<Kota> kotaList = repository.findAllByProvinceKodeProvince(codeProvince);
        List<KotaDto> kotaDtoList = kotaList.stream().map(kota-> assembler.fromEntity(kota))
                .collect(Collectors.toList());
        return DefaultResponse.ok(kotaDtoList);
    }

    /*Insert Data*/
    @PostMapping
    public DefaultResponse insert(@RequestBody KotaDto dto) {
        Kota kota = assembler.fromDto(dto);
        repository.save(kota);
        return DefaultResponse.ok(dto);
    }
}
