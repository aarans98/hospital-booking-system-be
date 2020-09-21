package com.bahagya.miniproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KecamatanDto {
    private String code;
    private String name;
    private String codeProvince;
    private String namaProvince;
    private String codeKota;
    private String namaKota;
}
