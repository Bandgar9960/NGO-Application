package com.neo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDto {

    private Long partnerId;

    @NotEmpty
    @Size(min = 2,message = "Name must be Atleast 2 character!! ")
    private String partnerOrganisation;


    @NotEmpty
    @Size(min = 10, max = 10, message = "Not Valid ADMIN_CONTACT !!!")
    private String partnerContact;

    @NotEmpty
    @Pattern(regexp= "((http|https)://)(www.)?"
            + "[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]"
            + "{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)",message = "website URL is not proper!!")
    private String partnerWebsite;

}
