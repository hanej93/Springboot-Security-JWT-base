package com.cos.jwt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;

public class MyFilter3 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		System.out.println("필터3");
		// 토큰 : cos 이걸 만들어줘야 함 id, pw 정상적으로 들어와서 로그인이 완료되면 토큰을 만들어주고 그걸 응답을 해준다.
		// 요청할 때 마다 header에 Authorization에 value값으로 토큰을 가지고 오고
		// 그때 토큰이 넘어오면 이 토큰이 내가 만든 토큰이 맞는지만 검증만 하면 됨(RSA, HS256)
		if(HttpMethod.POST.matches(req.getMethod())) {
			System.out.println("POST 요청됨");
			String headerAuth = req.getHeader("Authorization");
			System.out.println("headerAuth: " + headerAuth);
			
			if("cos".equals(headerAuth)) {
				chain.doFilter(req, resp);
			} else {
				PrintWriter outPrintWriter = resp.getWriter();
				outPrintWriter.println("인증안됨");
			}
		}
	}

	
}