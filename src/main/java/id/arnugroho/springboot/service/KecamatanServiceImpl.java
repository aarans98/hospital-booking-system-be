package id.arnugroho.springboot.service;

import id.arnugroho.springboot.assembler.KecamatanAssembler;
import id.arnugroho.springboot.model.dto.KecamatanDto;
import id.arnugroho.springboot.model.entity.Kecamatan;
import id.arnugroho.springboot.repository.KecamatanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KecamatanServiceImpl implements KecamatanService{
    @Autowired
    private KecamatanRepository repository;
    @Autowired
    private KecamatanAssembler assembler;

    @Override
    public KecamatanDto insertDataKecamatan(KecamatanDto dto) {
        Kecamatan entity = repository.save(assembler.fromDto(dto));
        repository.save(entity);
        return assembler.fromEntity(entity);
    }
}
