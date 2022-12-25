package com.neo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "login_details")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginId;

    @Column(name = "login_username")
    private String loginUsername;

    @Column(name = "login_password")
    private String loginPassword;

    @Column(name = "login_type")
    private String loginType;
}
