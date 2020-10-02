package com.bahagya.miniproject.controller;

//import com.bahagya.miniproject.assembler.JadwalDokterAssembler;
import com.bahagya.miniproject.model.dto.NotifikasiDokterDto;
import com.bahagya.miniproject.model.dto.NotifikasiPasienDto;
import com.bahagya.miniproject.model.entity.JadwalDokter;
import com.bahagya.miniproject.repository.JadwalDokterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/jadwal")
public class JadwalDokterController {
    @Autowired
    private JadwalDokterRepo repository;
//    @Autowired
//    private JadwalDokterAssembler assembler;

//    @GetMapping
//    public DefaultResponse get(){
//        List<JadwalDokter> jadwalDokterList = repository.findAll();
//        List<JadwalDokterDto> jadwalDokterDtoList = jadwalDokterList.stream().map(jadwalDokter -> assembler.fromEntity(jadwalDokter))
//                .collect(Collectors.toList());
//        return DefaultResponse.ok(jadwalDokterDtoList);
//    }

    @GetMapping("pasien/{user}")
    public List<NotifikasiPasienDto> getUserPasien(@PathVariable String user ){
        List<JadwalDokter> notifikasiList =repository.findAllByUsername(user);
        List<NotifikasiPasienDto> data = new ArrayList<>();
        for (int i = 0; i< notifikasiList.size(); i++){
            NotifikasiPasienDto jd = new NotifikasiPasienDto();
            jd.setNama_lengkap(notifikasiList.get(i).getNama_lengkap());
            jd.setNamaDokter(notifikasiList.get(i).getDokter().getNamaLengkap());
            jd.setJam(notifikasiList.get(i).getPraktek().getJam());
            jd.setTanggalKunjungan(notifikasiList.get(i).getPraktek().getJadwal());
            jd.setSpesialisasi(notifikasiList.get(i).getDokter().getSpesialisasi());

            data.add(jd);
        }
        return data;
    }

    @GetMapping("dokter/{userDokter}")
    public List<NotifikasiDokterDto> getUserDokter(@PathVariable String userDokter ){
        List<JadwalDokter> notifikasiList =repository.findAllByDokterUsername(userDokter);
        List<NotifikasiDokterDto> data = new ArrayList<>();
        for (int i = 0; i< notifikasiList.size(); i++){
            NotifikasiDokterDto jd = new NotifikasiDokterDto();
//            jd.setIdPasien(notifikasiList.get(i));
            jd.setIdJadwalDokter(notifikasiList.get(i).getId());
            jd.setNama_lengkap(notifikasiList.get(i).getNama_lengkap());
            jd.setJam(notifikasiList.get(i).getPraktek().getJam());
            jd.setTanggalKunjungan(notifikasiList.get(i).getPraktek().getJadwal());

            data.add(jd);
        }
        return data;
    }

    @GetMapping("/id")
    public List<Integer> getIdJadwalDokter() {
        List<JadwalDokter> JadwalDokterList = repository.findAll();
        List<Integer> IdJadwalDokterList = JadwalDokterList.stream().map(jd -> jd.getId()).collect(Collectors.toList());
        return IdJadwalDokterList;
    }


}