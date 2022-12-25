package com.neo.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Donor_Details")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donorId;

    @Column(name = "donar_name")
    private String donorName;

    @Column(name = "donar_contact")
    private String donorContact;

    @Column(name = "donar_pan")
    private String donorPAN;

    @Column(name = "donar_gender")
    private String donorGender;

    @Column(name = "donar_dob")
    private String donorDOB;

    @Column(name = "donar_amount")
    private Long donorAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_Id")
    private Login login;

    @Embedded
    private Address address;


}
