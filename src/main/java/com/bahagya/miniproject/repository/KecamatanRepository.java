package com.bahagya.miniproject.repository;

import com.bahagya.miniproject.model.entity.Kecamatan;
import com.bahagya.miniproject.model.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KecamatanRepository extends JpaRepository<Kecamatan, String> {
    /* 1. querynya menggunakan nama method
    * penamaan methodnya sesuai dengan nama variable
    * select * from t_kecamatan where kdprov = ""
    * */
    List<Kecamatan> findAllByProve(Province p);
    /* select * from t_kecamatan where kdprov = "" */
//    List<Kecamatan> findAllByProveKodeProvince(4);
    List<Kecamatan> findAllByProveKodeProvince(String kode);

    /*select * from t_kecamatan
    where kdkecamatan = ?n and nmkecamatan = ?k*/
    Kecamatan findByKodeKecamatanAndNamaKecamatan(String n, String k);

    List<Kecamatan> findByKodeKecamatanOrderByKodeKecamatan(String kode);
}
