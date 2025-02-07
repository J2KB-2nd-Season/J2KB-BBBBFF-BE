package com.j2kb.common;

public final class SecurityConstants {      
	// 로그인 인증 URL 정의
	public static final String AUTH_LOGIN_URL = "/api/authenticate";     
	// HS512 암호화 알고리즘 서명키 정의 
	public static final String JWT_SECRET = "p2s5v8y/B?E(H+KbPeShVmYq3t6w9z$C&F)J@NcQfTjWnZr4u7x!A%D*G-KaPdSg";     
	// JWT 토큰 기본 상수값 정의  
	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer "; 
	public static final String TOKEN_TYPE = "JWT"; 
	public static final String TOKEN_ISSUER = "rest-api"; 
	public static final String TOKEN_AUDIENCE = "rest-app";      
}