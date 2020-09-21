package com.bahagya.miniproject.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_kota")
public class Kota {
    @Id
    @Column(name = "kdkota", length = 25)
    private String kodeKota;

    @Column(name = "nmkota")
    private String namaKota;

    @ManyToOne
    @JoinColumn(name="kdprov",insertable = false, updatable = false)
    private Province province;

    @Column(name="kdprov", nullable = false)
    private String provinceId;

}
