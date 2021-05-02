package com.j2kb.common;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

// JWT를 생성 및 조회할 클래스 생성. 추후에 필터나 로그인 후 발행할 때에 사용한다.
public class JwtUtil {
	private Key key;
	
	public JwtUtil(String secret) {
		this.key = Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	public String createToken(long id, String name) {
		String token = Jwts.builder()
				.claim("member_id", id)
				.claim("member_name", name)
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
		return token;
	}
	
	public Claims getClaims(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(key)
				.parseClaimsJws(token)
				.getBody();
		return claims;
	}
}
