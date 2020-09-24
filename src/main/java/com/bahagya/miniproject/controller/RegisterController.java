
package com.bahagya.miniproject.controller;

import com.bahagya.miniproject.assembler.RegisterAssembler;
import com.bahagya.miniproject.configuration.DefaultResponse;
import com.bahagya.miniproject.model.dto.RegisterDto;
import com.bahagya.miniproject.model.dto.ResponLogin;
import com.bahagya.miniproject.model.entity.Register;
import com.bahagya.miniproject.repository.RegisterRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterRepo repository;
    @Autowired
    private RegisterAssembler assembler;

    // http://localhost:8080/pasien
    // @GetMapping
    // public DefaultResponse get() {
    // List<Pasien> pasienList = repository.findAll();
    // List<KunjunganDto> kunjunganDtoList = pasienList.stream().map(patient ->
    // assembler.fromEntity(patient))
    // .collect(Collectors.toList());
    // return DefaultResponse.ok(kunjunganDtoList);
    // }

    /* Insert Data */
    @PostMapping
    public DefaultResponse insert(@RequestBody RegisterDto dto) {
        Register register = assembler.fromDto(dto);
        repository.save(register);
        return DefaultResponse.ok(dto);
    }

    @GetMapping("/login")
    public ResponLogin get(@RequestParam String username, String password) {
        ResponLogin responLogin = new ResponLogin();
        Register register = repository.findById(username).get();
        if (register == null) {
            responLogin.setStat(false);
            responLogin.setUser_role(null);
            return responLogin;
        } else {
            if (password.equals(register.getPassword())) {
                responLogin.setStat(true);
                responLogin.setUser_role(register.getUser_role());
                return responLogin;
            } else {
                responLogin.setStat(true);
                responLogin.setUser_role(null);
                return responLogin;
            }
        }
    }

}
