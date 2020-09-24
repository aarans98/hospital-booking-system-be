package com.bahagya.miniproject.model.entity;

import java.sql.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "informasi_staf")
public class InformasiStaf {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_staf", nullable = false)
    private Integer idStaf;

    @Column(name = "nama_lengkap", nullable = false)
    private String namaLengkap;
    
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;
    
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggalLahir;

    @Column(name = "posisi", nullable = false)
    private String posisi;
    
    @Column(name = "mulai_bekerja", nullable = false)
    private Date mulaiBekerja;
    
    @Column(name = "gaji", nullable = false)
    private Integer gaji;

}