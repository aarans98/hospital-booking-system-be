package com.bahagya.miniproject.model.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "rekam_medik")
public class RekamMedik {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rekam_medik")
    private Integer idRekamMedik;

    @ManyToOne
    @JoinColumn(name = "id_pasien", insertable = false, updatable = false)
    private Pasien pasien;

    @Column(name = "id_pasien", nullable = false)
    private Integer idPasien;

    @ManyToOne
    @JoinColumn(name = "id_dokter", insertable = false, updatable = false)
    private Dokter dokter;

    @Column(name = "id_dokter", nullable = false)
    private Integer idDokter;

    @Column(name = "gejala")
    private String gejala;

    @OneToOne
    @JoinColumn(name = "id_praktek", insertable = false, updatable = false)
    private Praktek praktek;

    @Column(name = "id_praktek", nullable = false)
    private Integer idPraktek;

    @Column(name = "tanggal_kunjungan")
    private Date tanggalKunjungan;

    @Column(name = "tinggi_badan")
    private Integer tinggiBadan;

    @Column(name = "berat_badan")
    private Integer beratBadan;

    @Column(name = "diagnosa")
    private String diagnosa;

    @OneToMany(mappedBy = "rekamMedik")
    private List<RmObat> rmObat;

    @Column(name = "dosis")
    private String dosis;

}
