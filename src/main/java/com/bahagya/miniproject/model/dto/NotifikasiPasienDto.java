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
public class NotifikasiPasienDto {
	private String nama_lengkap;
	private String namaDokter;
	private String jam;
	private Date tanggalKunjungan;
	private String spesialisasi;


}
