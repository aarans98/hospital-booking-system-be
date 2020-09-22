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

    // @OneToMany
    // @JoinColumn(name = "id_dokter", nullable = false, updatable = false)
    // private Dokter idDokter;

}
