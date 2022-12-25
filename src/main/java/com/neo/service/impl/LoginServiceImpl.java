package com.neo.service.impl;

import com.neo.dto.LoginDto;
import com.neo.model.Login;
import com.neo.repository.LoginRepository;
import com.neo.service.LoginService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LoginDto getLogin(String loginUsername, String loginPassword) {
        logger.info("Initiating dao call for the get login details with loginUsername:{} and loginPassword:{}", loginUsername, loginPassword);
        Login login = this.loginRepository.getByLoginUsernameAndLoginPassword(loginUsername, loginPassword);
        logger.info("Completed dao call for the get login details with loginUsername :{} and loginPassword:{}", loginUsername, loginPassword);
        return this.modelMapper.map(login, LoginDto.class);
    }
}
