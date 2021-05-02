package com.j2kb.common;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

// JWT�� ���� �� ��ȸ�� Ŭ���� ����. ���Ŀ� ���ͳ� �α��� �� ������ ���� ����Ѵ�.
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
