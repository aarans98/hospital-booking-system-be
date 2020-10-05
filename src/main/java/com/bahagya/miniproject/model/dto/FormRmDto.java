package com.bahagya.miniproject.model.dto;

// import java.sql.Date;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormRmDto {
    private Integer id;
    private Integer idPasien;
    private Integer idJadwal;
    private Integer tinggiBadan;
    private Integer beratBadan;
    private String gejala;
    private String diagnosa;
    private List<String> namaObat;
    private String dosis;

}
