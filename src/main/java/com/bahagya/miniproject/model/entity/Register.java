package com.bahagya.miniproject.model.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "register")
public class Register {
<<<<<<< HEAD
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_user")
//    private Integer id_user;
	
    @Column(name = "user_role")
=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer id_user;

    @Column(name = "user_role", nullable = false, length = 6)
>>>>>>> refs/heads/development
    private String user_role;
<<<<<<< HEAD
    
    @Id
    @Column(name = "username")
=======

    @Column(name = "username", nullable = false, length = 15)
>>>>>>> refs/heads/development
    private String username;

    @Column(name = "password", nullable = false, length = 12)
    private String password;

    @Column(name = "passwordrep", nullable = false, length = 12)
    private String passwordrep;

    @Column(name = "email", nullable = false, length = 30)
    private String email;
}