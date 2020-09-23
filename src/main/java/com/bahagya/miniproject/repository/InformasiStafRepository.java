package com.bahagya.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bahagya.miniproject.model.entity.InformasiStaf;

@Repository
public interface InformasiStafRepository extends JpaRepository<InformasiStaf, Integer>  {

}
