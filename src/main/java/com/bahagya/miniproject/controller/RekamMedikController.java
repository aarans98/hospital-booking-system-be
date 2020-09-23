package com.bahagya.miniproject.controller;

import com.bahagya.miniproject.configuration.DefaultResponse;
import com.bahagya.miniproject.model.dto.RekamMedikDto;
import com.bahagya.miniproject.model.entity.RekamMedik;
import com.bahagya.miniproject.model.entity.RmObat;
import com.bahagya.miniproject.repository.RekamMedikRepository;
import com.bahagya.miniproject.repository.RmObatRepository;
import com.bahagya.miniproject.service.RekamMedikService;
import com.bahagya.miniproject.assembler.RekamMedikAssembler;
import com.bahagya.miniproject.assembler.RmObatAssembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rekam-medik")
public class RekamMedikController {
    @Autowired
    private RekamMedikRepository repository;
    @Autowired
    private RekamMedikService service;
    @Autowired
    private RekamMedikAssembler assembler;
    @Autowired
    private RmObatAssembler rmObatAssambler;
    @Autowired
    private RmObatRepository rmObatRepository;

    // http://localhost:8080/rekam-medik
    @GetMapping
    public DefaultResponse get() {
        List<RekamMedik> rekamMedikList = repository.findAll();
        List<RekamMedikDto> rekamMedikDtoList = rekamMedikList.stream()
                .map(rekamMedik -> assembler.fromEntity(rekamMedik)).collect(Collectors.toList());
        return DefaultResponse.ok(rekamMedikDtoList);
    }

    // http://localhost:8080/rekam-medik/1
    @GetMapping("/{id}")
    public DefaultResponse get(@PathVariable Integer id) {
        RekamMedikDto rekamMedikDto = assembler.fromEntity(repository.findById(id).get());
        return DefaultResponse.ok(rekamMedikDto);
    }

    @GetMapping("/pasien/{idPasien}")
    public DefaultResponse getByPasien(@PathVariable Integer idPasien) {
        List<RekamMedik> rekamMedikList = repository.findAllByPasienIdPasien(idPasien);
        List<RekamMedikDto> rekamMedikDtoList = rekamMedikList.stream().map(rekamMedik -> assembler.fromEntity(rekamMedik))
                .collect(Collectors.toList());
        return DefaultResponse.ok(rekamMedikDtoList);
    }

    // @GetMapping("/dokter/{idDokter}")
    // public DefaultResponse getByDokter(@PathVariable Integer idDokter) {
    //     List<RekamMedik> rekamMedikList = repository.findAllByDokterIdDokter(idDokter);
    //     List<RekamMedikDto> rekamMedikDtoList = rekamMedikList.stream().map(rekamMedik -> assembler.fromEntity(rekamMedik))
    //             .collect(Collectors.toList());
    //     return DefaultResponse.ok(rekamMedikDtoList);
    // }

    // @GetMapping("/praktek/{idPraktek}")
    // public DefaultResponse getByPraktek(@PathVariable Integer idPraktek) {
    //     List<RekamMedik> rekamMedikList = repository.findAllByPraktekIdPraktek(idPraktek);
    //     List<RekamMedikDto> rekamMedikDtoList = rekamMedikList.stream().map(rekamMedik -> assembler.fromEntity(rekamMedik))
    //             .collect(Collectors.toList());
    //     return DefaultResponse.ok(rekamMedikDtoList);
    // }

    // @GetMapping("/obat/{idObat}")
    // public DefaultResponse getByObat(@PathVariable Integer idObat) {
    //     List<RekamMedik> rekamMedikList = repository.findAllByObatIdObat(idObat);
    //     List<RekamMedikDto> rekamMedikDtoList = rekamMedikList.stream().map(rekamMedik -> assembler.fromEntity(rekamMedik))
    //             .collect(Collectors.toList());
    //     return DefaultResponse.ok(rekamMedikDtoList);
    // }

    @PostMapping
    public DefaultResponse insert(@RequestBody RekamMedikDto dto) {
        RekamMedik rekamMedik = assembler.fromDto(dto);
        repository.save(rekamMedik);
        if (!dto.getIdObat().isEmpty()){
            for(int i = 0; i < dto.getIdObat().size(); i++){
                RmObat rmObat = rmObatAssambler.toEntity(dto.getId(), dto.getIdObat().get(i));
                rmObatRepository.save(rmObat);
            }
        }
        return DefaultResponse.ok(assembler.fromEntity(rekamMedik));
    }

    @PostMapping("/trx")
    public DefaultResponse insertTrx(@RequestBody RekamMedikDto dto) {
        return DefaultResponse.ok(service.insertRekamMedik(dto));
    }

}
