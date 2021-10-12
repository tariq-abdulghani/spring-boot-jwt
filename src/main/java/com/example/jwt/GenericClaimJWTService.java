package com.example.jwt;

import java.security.Key;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class GenericClaimJWTService<C> {
	
	private String secret;
	
	public GenericClaimJWTService() {
		this.secret = "secret";
	}
	
	public GenericClaimJWTService(String secret) {
		this.secret = secret;
	}


	public String generateToken(Map<String,Object> claims) {
		
		Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
//		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

		String jws = Jwts
				.builder()
				.setSubject("Joe")
				.addClaims(claims)
				.signWith(key).compact();
		return jws;
	}
	
	public C verifyToken(String jwsString){
		Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
//		Jwts.parserBuilder()
//		  .setSigningKey(key) // <----
//		  .build()
//		  .parseClaimsJws(jwsString);
//		return null;
		
		Jws<Claims> jws;

		try {
		    jws = Jwts.parserBuilder()  // (1)
		    .setSigningKey(key)         // (2)
		    .build()                    // (3)
		    .parseClaimsJws(jwsString); // (4)
		    
		    // we can safely trust the JWT
		     
		catch (JwtException ex) {       // (5)
		    
		    // we *cannot* use the JWT as intended by its creator
		}
	}
}
