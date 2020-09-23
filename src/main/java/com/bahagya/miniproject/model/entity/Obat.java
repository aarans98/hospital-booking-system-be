package com.bahagya.miniproject.model.entity;

import lombok.Data;

import java.util.List;

import javax.persistence.*;


@Data
@Entity
@Table(name = "obat")
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

    // @ManyToMany(cascade = CascadeType.ALL)
    // @JoinTable(name = "rm_obat",
    //     joinColumns = @JoinColumn(name = "id_obat"),
    //     inverseJoinColumns = @JoinColumn(name = "id_rekam_medik"))
    // private List<RekamMedik> rekamMedik = new ArrayList<>();

    @OneToMany(mappedBy = "obat")
    private List<RmObat> rmObat;
}
