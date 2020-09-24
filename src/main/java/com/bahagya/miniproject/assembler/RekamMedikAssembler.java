package com.bahagya.miniproject.assembler;

import com.bahagya.miniproject.model.dto.RekamMedikDto;
import com.bahagya.miniproject.model.entity.RekamMedik;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RekamMedikAssembler {

    public RekamMedikDto fromEntity(RekamMedik entity) {
        if (entity == null) return null;
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
                .namaObat(entity.getRmObat().stream().map(obat -> obat.getObat().getNamaObat()).collect(Collectors.toList()))
                .deskripsi(entity.getRmObat().stream().map(obat -> obat.getObat().getDeskripsi()).collect(Collectors.toList()))
                .dosis(entity.getDosis())
                .build();
    }
    
}
