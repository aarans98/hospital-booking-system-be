
package com.bahagya.miniproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterDto {
    private Integer id_user;
    private String user_role;
    private String username;
    private String password;
    private String email;

}

