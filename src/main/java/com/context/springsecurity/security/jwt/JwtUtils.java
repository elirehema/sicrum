package com.context.springsecurity.security.jwt;

import com.context.springsecurity.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * -- This file created by eli on 16/06/2020 for springsecurity
 * --
 * -- Licensed to the Apache Software Foundation (ASF) under one
 * -- or more contributor license agreements. See the NOTICE file
 * -- distributed with this work for additional information
 * -- regarding copyright ownership. The ASF licenses this file
 * -- to you under the Apache License, Version 2.0 (the
 * -- "License"); you may not use this file except in compliance
 * -- with the License. You may obtain a copy of the License at
 * --
 * -- http://www.apache.org/licenses/LICENSE-2.0
 * --
 * -- Unless required by applicable law or agreed to in writing,
 * -- software distributed under the License is distributed on an
 * -- "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * -- KIND, either express or implied. See the License for the
 * -- specific language governing permissions and limitations
 * -- under the License.
 * --
 **/
@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);


    @Value("${bezkoder.app.jwtSecret}")
    private String jwtSecret;

    @Value("${bezkoder.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl)authentication.getPrincipal();
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
