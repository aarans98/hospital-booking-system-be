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
public class InformasiStafDto {
    private Integer idStaf;
    private String namaLengkap;
    private Date tanggalLahir;
    private String posisi;
    private Date mulaiBekerja;
    private Integer gaji;
}
