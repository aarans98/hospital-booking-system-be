
package com.bahagya.miniproject.assembler;

import com.bahagya.miniproject.model.dto.RegisterDto;
import com.bahagya.miniproject.model.entity.Register;
import com.bahagya.miniproject.repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterAssembler implements InterfaceAssembler<Register, RegisterDto> {
    @Autowired
    private RegisterRepo repository;

    @Override
    public Register fromDto(RegisterDto dto) {
        if (dto == null)
            return null;

        // if (dto.getId_user() != null) {
        // Optional<Register> temp = this.repository.findById(dto.getId_user());
        // if(temp.isPresent()){
        // entity = temp.get();
        // }
        // }

        Register entity = new Register();
        // if (dto.getId_user() != null)
        // entity.setId_user(dto.getId_user());
        if (dto.getUser_role() != null)
            entity.setUser_role(dto.getUser_role());
        if (dto.getUsername() != null)
            entity.setUsername(dto.getUsername());
        if (dto.getPassword() != null)
            entity.setPassword(dto.getPassword());
        if (dto.getPasswordrep() != null)
            entity.setPasswordrep(dto.getPasswordrep());
        if (dto.getEmail() != null)
            entity.setEmail(dto.getEmail());
        if (dto.getFullname() != null)
            entity.setFullname(dto.getFullname());

        return entity;

    }

    @Override
    public RegisterDto fromEntity(Register entity) {
        if (entity == null)
            return null;
        return RegisterDto.builder().username(entity.getUsername()).password(entity.getPassword())
                .email(entity.getEmail()).fullname(entity.getFullname()).build();
    }

}