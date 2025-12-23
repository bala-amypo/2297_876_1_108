// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     private final String secret = "secret-key";
//     private final long validity = 3600000; // 1 hour

//     public String generateToken(Long userId, String email, String role) {

//         Claims claims = Jwts.claims().setSubject(email);
//         claims.put("userId", userId);
//         claims.put("role", role);

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + validity))
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }

//     public Claims getClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(secret)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }
