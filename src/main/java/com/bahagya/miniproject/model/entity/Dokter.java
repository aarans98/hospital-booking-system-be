package com.bahagya.miniproject.model.entity;

import java.sql.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "dokter")
public class Dokter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dokter", nullable = false)
    private Integer idDokter;
    
    @OneToOne
 	@JoinColumn(name = "username", nullable = false, insertable=false, updatable=false)
    private Register register;
	
	@Column(name="username", nullable = false)
    private String username;

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    @Column(name = "tanggal_lahir")
    private Date tanggalLahir;

    @Column(name = "spesialisasi")
    private String spesialisasi;
}
