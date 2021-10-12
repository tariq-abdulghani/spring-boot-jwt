package com.example.jwt;

import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JWTUtilService {
	
	private String secret;
	
	
	
	public JWTUtilService() {
		this.secret = "secret";
	}
	
	

	public JWTUtilService(String secret) {
		this.secret = secret;
	}



	public String generateToken() {
		
		Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
//		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

		String jws = Jwts
				.builder()
				.setSubject("Joe")
				.claim("user", "user")
				.claim("role", "user")
				.signWith(key).compact();
		return jws;
	}
	
	public Boolean verifyToken(String jwtToken){
		return false;
	}
}
