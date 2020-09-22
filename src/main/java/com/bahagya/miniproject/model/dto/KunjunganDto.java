package com.bahagya.miniproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.sql.Date;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KunjunganDto {
	private Integer idPasien;
	private String nama_lengkap;
	private Date tanggal_lahir;
	private String alamat;
	private String jenis_kelamin;
	private Integer tinggi_badan;
	private Integer berat_badan;
	private Integer usia;

}