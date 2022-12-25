package com.neo.repository;

import com.neo.dto.LoginDto;
import com.neo.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<Login , Long> {
   // @Query(name = "select new package.Login(a.login_username, a.login_password) from Login a")
    Login getByLoginUsernameAndLoginPassword(String loginUsername, String loginPassword);

}
