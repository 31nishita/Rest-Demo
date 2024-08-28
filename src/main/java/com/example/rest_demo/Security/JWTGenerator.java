package com.example.rest_demo.Security;

import org.springframework.security.core.Authentication;

import java.util.Date;

public class JWTGenerator {
    public String generateToken(Authentication authentication){
        String username= authentication.getName();
        Date currentDate=new Date   ();
        Date expireDate=new Date(currentDate.getTime()+SecurityConstants.JWT_EXPIRATION);
        String token=jwt.builder()

    }
}
