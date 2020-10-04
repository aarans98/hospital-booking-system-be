
package com.bahagya.miniproject.controller;

import com.bahagya.miniproject.assembler.RegisterAssembler;
import com.bahagya.miniproject.configuration.DefaultResponse;
import com.bahagya.miniproject.model.dto.RegisterDto;
import com.bahagya.miniproject.model.dto.ResponLogin;
import com.bahagya.miniproject.model.dto.authmail;
import com.bahagya.miniproject.model.entity.Register;
import com.bahagya.miniproject.repository.RegisterRepo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
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
    public Register insert(@RequestBody RegisterDto dto) {
        List<Register> registerList = repository.findAll();
        List<Boolean> nameCheck = registerList.stream().map(x -> x.getUsername().equals(dto.getUsername()))
                .collect(Collectors.toList());
        List<Boolean> mailCheck = registerList.stream().map(x -> x.getEmail().equals(dto.getEmail()))
                .collect(Collectors.toList());

        Register register = new Register();
        if ((!nameCheck.contains(true)) && (!mailCheck.contains(true))) {
            register = assembler.fromDto(dto);
            repository.save(register);
        }
        return register;
    }

    @PostMapping("/forgot")
    public ResponLogin forgot(@RequestParam String username, String password, String passwordrep) {
        ResponLogin respon = new ResponLogin();
        Register register = repository.findById(username).get();
        if (password.equals(passwordrep)) {
            register.setPassword(password);
            register.setPasswordrep(passwordrep);
            repository.save(register);
            respon.setStatus(true);
            return respon;
        } else {
            respon.setStatus(false);
            return respon;
        }
    }

    @GetMapping("/authmail")
    public authmail authmail(@RequestParam String username) {
        authmail tes = new authmail();
        Register register = repository.findById(username).get();
        tes.setMail(register.getEmail());
        return tes;
    }

    @GetMapping("/login")
    public ResponLogin get(@RequestParam String username, String password) {
        ResponLogin responLogin = new ResponLogin();
        Register register = repository.findById(username).get();
        if (register == null) {
            responLogin.setStatus(false);
            responLogin.setUser_role(null);
            return responLogin;
        } else {
            if (password.equals(register.getPassword())) {
                responLogin.setStatus(true);
                responLogin.setUser_role(register.getUser_role());
                responLogin.setUsername(register.getUsername());
                responLogin.setFullname(register.getFullname());
                return responLogin;
            } else {
                responLogin.setStatus(true);
                responLogin.setUsername(register.getUsername());
                responLogin.setUser_role(null);
                return responLogin;
            }
        }
    }

}
