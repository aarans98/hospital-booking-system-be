package com.bahagya.miniproject.model.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "rm_obat")
public class RmObat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rm_obat")
    private Integer idRmObat;

    @ManyToOne
    @JoinColumn(name = "id_rekam_medik")
    private RekamMedik rekamMedik;

    @ManyToOne
    @JoinColumn(name = "id_obat")
    private Obat obat;

}
