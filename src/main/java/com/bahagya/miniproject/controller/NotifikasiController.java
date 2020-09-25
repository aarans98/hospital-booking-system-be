package com.bahagya.miniproject.controller;

import com.bahagya.miniproject.assembler.ListDokterAssembler;
import com.bahagya.miniproject.configuration.DefaultResponse;
import com.bahagya.miniproject.model.dto.ListDokterDto;
import com.bahagya.miniproject.model.dto.NotifikasiDto;
import com.bahagya.miniproject.model.entity.Dokter;
import com.bahagya.miniproject.model.entity.JadwalDokter;
import com.bahagya.miniproject.model.entity.Praktek;
import com.bahagya.miniproject.repository.DokterRepo;
import com.bahagya.miniproject.repository.JadwalDokterRepo;
import com.bahagya.miniproject.repository.PraktekRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/notifikasi")
public class NotifikasiController {

    @Autowired
    private JadwalDokterRepo repository;
    @Autowired
    private ListDokterAssembler assembler;

//    @GetMapping
//    public DefaultResponse get(@RequestParam String username) {
//    	List<JadwalDokter> antrian=repository.findNamaDokterByUsername(username);
//        antrian.set
////        return DefaultResponse.ok(notifDto);
//    }


}