package com.app.driver.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletException;
import java.util.Date;

/**
 * Desc:生成token
 * Author: dalin
 * Data: 2018/5/18
 * Time: 17:39
 */
public class CreateJwtToken {

    public static String createJwtToken(String setSubject,String roles) throws ServletException{
        try {
            String jwtToken = Jwts.builder()
                    .setSubject(setSubject)
                    .claim("roles",roles)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000 * 10))
                    .signWith(SignatureAlgorithm.HS256,"wqsckey")
                    .compact();
            return jwtToken;
        }catch (Exception e){
            throw new ServletException("create token fail,"+e);
        }
    }
}
