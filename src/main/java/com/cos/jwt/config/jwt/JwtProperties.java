package com.cos.jwt.config.jwt;

public interface JwtProperties {
	String SECRET = "비밀키!!"; // 우리 서버만 알고 있는 비밀값
	int EXPIRATION_TIME = 10 * 60 * 1000; // 10분
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_STRING = "Authorization";
}