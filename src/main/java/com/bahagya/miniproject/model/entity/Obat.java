package com.bahagya.miniproject.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_obat")
public class Obat {
    @Id
    @Column(name = "id_obat", length = 25)
    private String idObat;

    @Column(name = "nama_obat")
    private String namaObat;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "kategori")
    private String kategori;

    @ManyToMany
    @JoinColumn(name="id_rekam_medik",insertable = false, updatable = false)
    private RekamMedik rekamMedik;
}
