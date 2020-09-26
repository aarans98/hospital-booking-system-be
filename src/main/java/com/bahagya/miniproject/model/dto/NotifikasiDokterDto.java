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
public class NotifikasiDokterDto {
    private String nama_lengkap;
//    private String jenisKelamin;
    private Integer idPasien;
    private String jam;
    private Date tanggalKunjungan;

}
