package id.arnugroho.springboot.assembler;

import id.arnugroho.springboot.model.dto.KecamatanDto;
import id.arnugroho.springboot.model.dto.ProvinceDto;
import id.arnugroho.springboot.model.entity.Kecamatan;
import id.arnugroho.springboot.model.entity.Province;
import id.arnugroho.springboot.repository.KecamatanRepository;
import id.arnugroho.springboot.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProvinsiAssembler implements InterfaceAssembler<Province, ProvinceDto> {

    @Autowired
    private ProvinceRepository repository;

    @Override
    public Province fromDto(ProvinceDto dto) {
        if (dto == null)
            return null;

        Province entity = new Province();
        if (dto.getCode() != null) {
            Optional<Province> temp = this.repository.findById(dto.getCode());
            if(temp.isPresent()){
                entity = temp.get();
            }
        }

        if (dto.getCode() != null) entity.setKodeProvince(dto.getCode());
        if (dto.getName() != null) entity.setNamaProvince(dto.getName());

        return entity;
    }

    @Override
    public ProvinceDto fromEntity(Province entity) {
        if (entity == null) return null;
        return ProvinceDto.builder()
                .code(entity.getKodeProvince())
                .name(entity.getNamaProvince())
                .build();
    }

}
