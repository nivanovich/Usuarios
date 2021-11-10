package com.evaluacion.ntt.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.evaluacion.ntt.dao.UsuarioRepository;
import com.evaluacion.ntt.dto.LoginRequest;
import com.evaluacion.ntt.dto.LoginResponse;
import com.evaluacion.ntt.dto.UsuarioRequest;
import com.evaluacion.ntt.dto.UsuarioResponse;
import com.evaluacion.ntt.entity.Login;
import com.evaluacion.ntt.entity.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthorizationService {
	
	@Autowired
	UsuarioRepository dao;
	@Autowired
	Mapper mapper;
	public LoginResponse validateUser(LoginRequest loginReq) {
		Login login=mapper.map(loginReq, Login.class);
		
		login.setToken(getToken(loginReq.getUsuario()));
		LoginResponse loginRes=mapper.map(login, LoginResponse.class);
		
		return loginRes;
		
	}
	private String getToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("NTTJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
