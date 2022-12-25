package com.neo.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Entity
@Table(name = "admin_details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "admin_contact")
    private String adminContact;

    @Column(name = "admin_aadhar")
    private String adminAadhar;

    @Column(name = "admin_gender")
    private String adminGender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_Id")
    private Login login;

    @Embedded
    private Address address;


}
