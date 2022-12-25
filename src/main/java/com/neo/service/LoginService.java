package com.neo.service;

import com.neo.dto.LoginDto;

public interface LoginService {

    LoginDto getLogin(String loginUsername, String loginPassword);
}
