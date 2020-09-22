package com.bahagya.miniproject.model.entity;

import lombok.Data;
import java.sql.Date;
import javax.persistence.*;

@Data
@Entity
@Table(name = "pasien")
public class Pasien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPasien")
    private Integer id_pasien;

    @Column(name = "nama")
    private String nama_lengkap;

    @Column(name = "tgl_lahir")
    private Date tanggal_lahir;

    @Column(name = "alamat")
    private String alamat;
    
    @Column(name = "gender")
    private String jenis_kelamin;
    
    @Column(name = "tb")
    private Integer tinggi_badan;
    
    @Column(name = "bb")
    private Integer berat_badan;
    
    @Column(name = "usia")
    private Integer usia;
    
}