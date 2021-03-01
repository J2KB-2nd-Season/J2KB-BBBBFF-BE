package com.j2kb.common;

public final class SecurityConstants {      
	// �α��� ���� URL ����
	public static final String AUTH_LOGIN_URL = "/api/authenticate";     
	// HS512 ��ȣȭ �˰��� ����Ű ���� 
	public static final String JWT_SECRET = "p2s5v8y/B?E(H+KbPeShVmYq3t6w9z$C&F)J@NcQfTjWnZr4u7x!A%D*G-KaPdSg";     
	// JWT ��ū �⺻ ����� ����  
	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer "; 
	public static final String TOKEN_TYPE = "JWT"; 
	public static final String TOKEN_ISSUER = "rest-api"; 
	public static final String TOKEN_AUDIENCE = "rest-app";      
}