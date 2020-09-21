package com.bahagya.miniproject.controller;

import com.bahagya.miniproject.configuration.DefaultResponse;
import com.bahagya.miniproject.model.dto.KecamatanDto;
import com.bahagya.miniproject.model.entity.Kecamatan;
import com.bahagya.miniproject.repository.KecamatanRepository;
import com.bahagya.miniproject.service.KecamatanService;
import com.bahagya.miniproject.assembler.KecamatanAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/kecamatan")
public class KecamatanController {
    @Autowired
    private KecamatanRepository repository;
    @Autowired
    private KecamatanService service;
    @Autowired
    private KecamatanAssembler assembler;


    // http://localhost:8080/kecamatan
    @GetMapping
    public DefaultResponse get() {
        List<Kecamatan> kotaList = repository.findAll();
        List<KecamatanDto> kotaDtoList = kotaList.stream().map(kota -> assembler.fromEntity(kota))
                .collect(Collectors.toList());
        return DefaultResponse.ok(kotaDtoList);
    }

    // http://localhost:8080/kecamatan/3303
    @GetMapping("/{code}")
    public DefaultResponse get(@PathVariable String code) {
        KecamatanDto kecamatanDto = assembler.fromEntity(repository.findById(code).get());
        return DefaultResponse.ok(kecamatanDto);
    }

    @GetMapping("/prov/{codeProvince}")
    public DefaultResponse getByProvince(@PathVariable String codeProvince) {
//        List<Kecamatan> kecamatanList = kecamatanRepository.findAllByProveKodeProvince(4);
        List<Kecamatan> kecamatanList = repository.findAllByProveKodeProvince(codeProvince);
//        Province province = provinceRepository.findById(codeProvince).get();
//        List<Kecamatan> kecamatanList = kecamatanRepository.findAllByProve(province);
        List<KecamatanDto> kecamatanDtoList = kecamatanList.stream().map(kota -> assembler.fromEntity(kota))
                .collect(Collectors.toList());
        return DefaultResponse.ok(kecamatanDtoList);
    }

    /*Insert Data*/
    @PostMapping
    public DefaultResponse insert(@RequestBody KecamatanDto dto) {
        Kecamatan kecamatan = assembler.fromDto(dto);
        repository.save(kecamatan);
        return DefaultResponse.ok(assembler.fromEntity(kecamatan));
    }

    /*Insert Data*/
    @PostMapping("/trx")
    public DefaultResponse insertTrx(@RequestBody KecamatanDto dto) {
        return DefaultResponse.ok(service.insertDataKecamatan(dto));
    }

}
