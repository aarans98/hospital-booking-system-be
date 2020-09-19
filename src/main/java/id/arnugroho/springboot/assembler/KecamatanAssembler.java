package id.arnugroho.springboot.assembler;

import id.arnugroho.springboot.model.dto.KecamatanDto;
import id.arnugroho.springboot.model.entity.Kecamatan;
import id.arnugroho.springboot.repository.KecamatanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KecamatanAssembler implements InterfaceAssembler<Kecamatan, KecamatanDto> {

    @Autowired
    private KecamatanRepository repository;

    @Override
    public Kecamatan fromDto(KecamatanDto dto) {
        if (dto == null)
            return null;

        Kecamatan entity = new Kecamatan();
        if (dto.getCode() != null) {
            Optional<Kecamatan> temp = this.repository.findById(dto.getCode());
            if(temp.isPresent()){
                entity = temp.get();
            }
        }

        if (dto.getCode() != null) entity.setKodeKecamatan(dto.getCode());
        if (dto.getName() != null) entity.setNamaKecamatan(dto.getName());
        if (dto.getCodeProvince() != null) entity.setProveId(dto.getCodeProvince());
        if (dto.getCodeKota() != null) entity.setKotaId(dto.getCodeKota());

        return entity;
    }

    @Override
    public KecamatanDto fromEntity(Kecamatan entity) {
        if (entity == null) return null;
        return KecamatanDto.builder()
                .code(entity.getKodeKecamatan())
                .namaKota(entity.getNamaKecamatan())
                .codeProvince(entity.getProve().getKodeProvince())
                .namaProvince(entity.getProve().getNamaProvince())
                .codeKota(entity.getKota().getKodeKota())
                .namaKota(entity.getKota().getNamaKota())
                .build();
    }

}
