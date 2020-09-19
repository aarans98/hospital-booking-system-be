package id.arnugroho.springboot.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_kecamatan")
public class Kecamatan {
    @Id
    @Column(name = "kdkecamatan", length = 25)
    private String kodeKecamatan;

    @Column(name = "nmkecamatan")
    private String namaKecamatan;

    @ManyToOne
    @JoinColumn(name = "kdkota", insertable = false, updatable = false)
    private Kota kota;

    @Column(name = "kdkota", nullable = false)
    private String kotaId;

    @ManyToOne
    @JoinColumn(name = "kdprov", insertable = false, updatable = false)
    private Province prove;

    @Column(name = "kdprov", nullable = false)
    private String proveId;

}
