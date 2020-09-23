package com.bahagya.miniproject.model.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer id_user;

    @Column(name = "user_role", nullable = false, length = 6)
    private String user_role;

    @Column(name = "username", nullable = false, length = 15)
    private String username;

    @Column(name = "password", nullable = false, length = 12)
    private String password;

    @Column(name = "passwordrep", nullable = false, length = 12)
    private String passwordrep;

    @Column(name = "email", nullable = false, length = 30)
    private String email;
}