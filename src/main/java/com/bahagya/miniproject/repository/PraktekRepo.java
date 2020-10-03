package com.bahagya.miniproject.repository;

import com.bahagya.miniproject.model.entity.Praktek;
import com.bahagya.miniproject.model.entity.JadwalDokter;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PraktekRepo extends JpaRepository<Praktek, Integer> {
	List<Praktek> findAllByDokterIdDokter(Integer idDokter);

	@Query(value = "select *\n" +
			"from praktek as p\n" +
			"where p.id_praktek not in (select j.id_praktek from jadwaldokter as j) and p.id_dokter = ?;", nativeQuery = true)
	List<Praktek> findAvailablePraktek(Integer idDokter);
}
