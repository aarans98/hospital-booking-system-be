package com.bahagya.miniproject.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RekamMedikDto {
    private String id;
    private Integer idPasien;
    private Integer idDokter;
    private String gejala;
    private Integer idPraktek;
    private Date tanggalKunjungan;
    private Integer tinggiBadan;
    private Integer beratBadan;
    private String diagnosa;
    private Integer idObat;
    private String dosis;
}
