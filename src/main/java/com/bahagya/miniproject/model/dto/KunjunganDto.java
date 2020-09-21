package com.bahagya.miniproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KunjunganDto {
	private Integer id_pasien;
	private String nama_lengkap;
	private String tanggal_lahir;
	private String alamat;
	private String jenis_kelamin;
	private Integer tinggi_badan;
	private Integer berat_badan;
	private Integer usia;

}
