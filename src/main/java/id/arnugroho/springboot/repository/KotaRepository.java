package id.arnugroho.springboot.repository;

import id.arnugroho.springboot.model.entity.Kota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KotaRepository extends JpaRepository<Kota, String> {

    List<Kota> findAllByProvinceKodeProvince(String codeProvince);
}
