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

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    @Column(name = "tanggal_lahir")
    private Date tanggalLahir;

    @Column(name = "spesialisasi")
    private String spesialisasi;
}
