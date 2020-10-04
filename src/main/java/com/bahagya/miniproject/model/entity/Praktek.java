package com.bahagya.miniproject.model.entity;

import java.sql.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "praktek")
public class Praktek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_praktek", nullable = false)
    private Integer idPraktek;

    @Column(name = "poli", nullable = false)
    private String poli;

    @Column(name = "jadwal", nullable = false)
    private Date jadwal;

    @Column(name = "jam")
    private String jam;

    @Column(name = "tersedia")
    private String tersedia;

    @ManyToOne
    @JoinColumn(name = "id_dokter", insertable = false, updatable = false)
    private Dokter dokter;

    @Column(name = "id_dokter", nullable = false)
    private Integer idDokter;
}
