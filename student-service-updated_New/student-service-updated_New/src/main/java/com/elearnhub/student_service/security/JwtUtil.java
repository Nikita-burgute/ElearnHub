package com.elearnhub.student_service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

	private static final String SECRET_KEY = "dNrV3H3xvcmb9DeBQFUbI6B8VT1EuhiUpfKHKwxRsYXpPSHYyImzcRZWVdmWnKyOFSv1cLMQu8fHP3bs1xCr0oS5W1CEVRyqjPgwXlnocYA7F2gWMwimARqcxB5IHq4N";

    // Convert secret string to Key object for HS256
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String extractUsername(String token) {
        try {
            return extractClaim(token, Claims::getSubject);
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("❌ Error extracting username: " + e.getMessage());
            return null;
        }
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claims != null ? claimsResolver.apply(claims) : null;
    }
//
//    private Claims extractAllClaims(String token) {
//        try {
//            return Jwts.parserBuilder()
//                    .setSigningKey(getSigningKey())
//                    .build()                  // must build before parsing
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (ExpiredJwtException e) {
//            System.out.println("⚠️ Token expired: " + e.getMessage());
//        } catch (JwtException e) {
//            System.out.println("⚠️ Invalid token: " + e.getMessage());
//        } catch (Exception e) {
//            System.out.println("⚠️ Unexpected JWT error: " + e.getMessage());
//        }
//        return null;
//    }

    
    private Claims extractAllClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8)) // byte array
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            System.out.println("⚠️ Token expired: " + e.getMessage());
        } catch (JwtException e) {
            System.out.println("⚠️ Invalid token: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("⚠️ Unexpected JWT error: " + e.getMessage());
        }
        return null;
    }

    
//    private Claims extractAllClaims(String token) {
//        try {
//            return Jwts.parser()
//                    .verifyWith(SECRET_KEY)
//                    .build()
//                    .parseSignedClaims(token)
//                    .getPayload();
//        } catch (Exception e) {
//            throw new RuntimeException("Invalid JWT token: " + e.getMessage(), e);
//        }
//    }

    private boolean isTokenExpired(String token) {
        Date expiration = extractExpiration(token);
        return expiration != null && expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        if (userDetails == null) return false;
        String username = extractUsername(token);
        return username != null && username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
}
