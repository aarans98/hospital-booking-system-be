package com.bahagya.miniproject.repository;

import com.bahagya.miniproject.model.entity.Praktek;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PraktekRepo extends JpaRepository<Praktek, Integer> {

}
