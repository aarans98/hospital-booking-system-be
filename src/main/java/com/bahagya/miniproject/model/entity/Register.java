package com.bahagya.miniproject.model.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "register")
public class Register {

    @Column(name = "user_role", nullable = false)
    private String user_role;

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id_username")
    // private Integer idUsername;

    @Id
    @Column(name = "username", nullable = false, length = 15, unique = true)
    private String username;

    @Column(name = "namaLengkap", nullable = false)
    private String fullname;

    @Column(name = "password", nullable = false, length = 12)
    private String password;

    @Column(name = "passwordrep", nullable = false, length = 12)
    private String passwordrep;

    @Column(name = "email", nullable = false, length = 30, unique = true)
    private String email;
}