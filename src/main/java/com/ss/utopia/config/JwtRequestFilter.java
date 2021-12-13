package com.ss.utopia.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ss.utopia.entity.User;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
	
	RestTemplate rt = new RestTemplate();
	@Value("${user.url}")
	String usersUrl;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");
//		String jwtToken = requestTokenHeader.substring(7);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", requestTokenHeader);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		try{
			ResponseEntity<String> verification = rt.exchange(usersUrl + "/verify", HttpMethod.GET, entity, String.class);
		}catch(HttpClientErrorException e) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return;
		}catch(Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return;
		}

		chain.doFilter(request, response);
	}
}