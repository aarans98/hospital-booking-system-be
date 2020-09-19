package id.arnugroho.springboot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* Disini kita akan merepresentasikan data provinsi
* contoh data yang diinginkan adalah
* {"code":"32","name":"Jawa Barat","code":"33","name":"Jawa Tengah",...}
* sehingga kita membutuhkan code dan name sebagai nama atributnya
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProvinceDto {
    private String code;
    private String name;
}
