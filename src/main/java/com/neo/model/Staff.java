package com.neo.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "STAFF_DETAILS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "staff_contact")
    private String staffContact;

    @Column(name = "staff_aadhaar")
    private String staffAadhaar;

    @Column(name = "staff_designation")
    private String staffDesignation;

    @Column(name = "staff_department")
    private String staffDepartment;

    @Column(name = "staff_gender")
    private String staffGender;

    @Column(name = "staff_dob")
    private String staffDOB;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_Id")
    private Login login;

    @Embedded
    private Address address;
}
