package com.bahagya.miniproject.assembler;

import com.bahagya.miniproject.model.dto.RekamMedikDto;
import com.bahagya.miniproject.model.entity.RekamMedik;
import com.bahagya.miniproject.model.entity.RmObat;
import com.bahagya.miniproject.repository.RmObatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RekamMedikAssembler {

    @Autowired
    private RmObatRepository rmObatRepository;

    public RekamMedikDto fromEntity(RekamMedik entity) {
        if (entity == null) return null;
        List<RmObat> rmObat = rmObatRepository.findAllByRekamMedikIdRekamMedik(entity.getIdRekamMedik());
        return RekamMedikDto.builder()
                .id(entity.getIdRekamMedik())
                .tanggalKunjungan(entity.getTanggalKunjungan())
                .namaPasien(entity.getPasien().getNama_lengkap())
                .tanggalLahir(entity.getPasien().getTanggal_lahir())
                .usia(entity.getPasien().getUsia())
                .tinggiBadan(entity.getTinggiBadan())
                .beratBadan(entity.getBeratBadan())
                .gejala(entity.getGejala())
                .diagnosa(entity.getDiagnosa())
                .namaDokter(entity.getDokter().getNamaLengkap())
                .spesialisasi(entity.getDokter().getSpesialisasi())
                .poli(entity.getPraktek().getPoli())
                .jadwal(entity.getPraktek().getJadwal())
                .namaObat(rmObat.stream().map(obat -> obat.getObat().getNamaObat()).collect(Collectors.toList()))
                .deskripsi(rmObat.stream().map(obat -> obat.getObat().getDeskripsi()).collect(Collectors.toList()))
                .dosis(entity.getDosis())
                .build();
    }
    
}
