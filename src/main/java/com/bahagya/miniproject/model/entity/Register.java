package com.bahagya.miniproject.model.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "register")
public class Register {

	
    @Column(name = "user_role")
    private String user_role;
    
    @Id
    @Column(name = "username", nullable = false, length = 15)
    private String username;

    @Column(name = "password", nullable = false, length = 12)
    private String password;

    @Column(name = "passwordrep", nullable = false, length = 12)
    private String passwordrep;

    @Column(name = "email", nullable = false, length = 30)
    private String email;
}