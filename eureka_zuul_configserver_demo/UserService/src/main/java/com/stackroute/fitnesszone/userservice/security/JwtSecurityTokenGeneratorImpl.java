package com.stackroute.fitnesszone.userservice.security;

import com.stackroute.fitnesszone.userservice.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

    @Override
    public Map<String, String> generateToken(User user) {

        String jwtToken = null;

        jwtToken = Jwts.builder().setIssuer("FitnessZone").setSubject(user.getEmail())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"fitnessZoneSecret")
                .compact();

        Map<String, String> map = new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","Authentication Successful");

        return map;
    }
}
