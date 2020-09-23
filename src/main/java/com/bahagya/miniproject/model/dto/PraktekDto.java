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
public class PraktekDto {
	private Integer idPraktek;
	private String poli;
	private Date jadwal;
	private Integer idDokter;
}
