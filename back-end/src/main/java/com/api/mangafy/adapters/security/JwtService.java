package com.api.mangafy.adapters.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Value("${jwt.secret}")
	private String secretKey;

	public String generateToken(UserPrincipal user) {
		List<String> roles = user.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority).toList();

		return Jwts.builder()
				.setSubject(user.getUsername())
				.claim("roles", roles)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 3600000))
				.signWith(Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256)
				.compact();
	}
	
	public String extractUsername(String token) {
	    return Jwts.parserBuilder()
	            .setSigningKey(secretKey.getBytes())
	            .build()
	            .parseClaimsJws(token)
	            .getBody()
	            .getSubject();
	}
}