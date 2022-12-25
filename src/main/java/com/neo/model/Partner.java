package com.neo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "partner_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partnerId;

    @Column(name = "partner_organization")
    private String partnerOrganisation;

    @Column(name = "partner_contact")
    private String partnerContact;

    @Column(name = "partner_website")
    private String partnerWebsite;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_Id")
    private Login login;

    @Embedded
    private Address address;

}
