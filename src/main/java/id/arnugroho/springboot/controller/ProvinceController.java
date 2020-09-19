package id.arnugroho.springboot.controller;

import id.arnugroho.springboot.assembler.ProvinsiAssembler;
import id.arnugroho.springboot.configuration.DefaultResponse;
import id.arnugroho.springboot.model.dto.ProvinceDto;
import id.arnugroho.springboot.model.entity.Province;
import id.arnugroho.springboot.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private ProvinceRepository repository;
    @Autowired
    private ProvinsiAssembler assembler;

    // http://localhost:8080/province
    @GetMapping
    public DefaultResponse get() {
        List<Province> provinceList = repository.findAll();
        List<ProvinceDto> provinceDtoList = provinceList.stream().map(provinsi -> assembler.fromEntity(provinsi))
                .collect(Collectors.toList());
        return DefaultResponse.ok(provinceDtoList);
    }

    // http://localhost:8080/province/33
    @GetMapping("/{code}")
    public DefaultResponse get(@PathVariable String code) {
        ProvinceDto provinceDto = assembler.fromEntity(repository.findById(code).get());
        return DefaultResponse.ok(provinceDto);
    }

    /*Insert Data*/
    @PostMapping
    public DefaultResponse insert(@RequestBody ProvinceDto dto) {
        Province province = assembler.fromDto(dto);
        repository.save(province);
        return DefaultResponse.ok(dto);
    }
}
