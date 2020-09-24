package com.bahagya.miniproject.repository;

import com.bahagya.miniproject.model.entity.Praktek;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PraktekRepo extends JpaRepository<Praktek, Integer> {
	List<Praktek> findAllByDokterIdDokter(Integer idDokter);
}
