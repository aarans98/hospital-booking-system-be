package com.bahagya.miniproject.model.dto;

import java.sql.Date;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RekamMedikDto {
    private Integer id;
    private Integer idPasien;
    // private String namaPasien;
    // private Date tanggalLahir;
    // private Integer usia;
    // private Integer idDokter;
    // private String namaDokter;
    // private String spesialisasi;
    private String gejala;
    // private Integer idPraktek;
    // private String poli;
    // private Date jadwal;
    private Date tanggalKunjungan;
    private Integer tinggiBadan;
    private Integer beratBadan;
    private String diagnosa;
    private List<String> idObat;
    private List<String> namaObat;
    private List<String> deskripsi;
    private String dosis;

}
