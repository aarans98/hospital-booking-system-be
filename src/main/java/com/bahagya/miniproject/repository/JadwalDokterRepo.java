package com.bahagya.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.bahagya.miniproject.model.entity.JadwalDokter;

@Repository
public interface JadwalDokterRepo extends JpaRepository<JadwalDokter, Integer> {
	List<JadwalDokter> findByUsername(String username);

    List<JadwalDokter> findAllByDokterIdDokter(Integer idDokter);

    List<JadwalDokter> findAllByPraktekIdPraktek(Integer idPraktek);
    
    
    @Query(
    value = "SELECT d.nama_lengkap as nmdokter, d.spesialisasi, p.jadwal,p.jam, a.pasien, a.username\r\n" + 
    		"FROM jadwaldokter a" + 
    		"INNER JOIN dokter d ON a.id_dokter=d.id_dokter" + 
    		"INNER JOIN praktek p ON a.id_praktek=p.id_praktek" + 
    		"WHERE a.username=?1", nativeQuery = true)
    List<JadwalDokter> findNamaDokterByUsername(String username);
}
