package com.bahagya.miniproject.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.bahagya.miniproject.model.entity.JadwalDokter;
import com.bahagya.miniproject.repository.JadwalDokterRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/jadwal-dokter")
public class JadwalDokterController {
    @Autowired
    private JadwalDokterRepo repository;

    // http://localhost:8080/jadwal-dokter/id
    @GetMapping("/id")
    public List<Integer> getIdObat() {
        List<JadwalDokter> JadwalDokterList = repository.findAll();
        List<Integer> IdJadwalDokterList = JadwalDokterList.stream().map(jd -> jd.getId()).collect(Collectors.toList());
        return IdJadwalDokterList;
    }
}
