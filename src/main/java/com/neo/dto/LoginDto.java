package com.neo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private Long loginId;

    @NotEmpty
    private String loginUsername;

    @NotEmpty
    private String loginPassword;

    @NotEmpty
    private String loginType;
}
