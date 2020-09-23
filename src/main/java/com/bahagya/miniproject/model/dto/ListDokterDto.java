package com.bahagya.miniproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListDokterDto {
    private Integer idDokter;
    private String namaLengkap;
    private String spesialisasi;
    private Date tanggalLahir;
}
