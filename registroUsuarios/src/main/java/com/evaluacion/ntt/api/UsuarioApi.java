package com.evaluacion.ntt.api;
import com.evaluacion.ntt.entity.Usuario;
import com.evaluacion.ntt.service.UsuarioService;
import com.evaluacion.ntt.dto.UsuarioRequest;
import com.evaluacion.ntt.dto.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.dozer.Mapper;
@RestController
public class UsuarioApi {
	@Autowired
	UsuarioService service;
	@Autowired
	Mapper mapper;
	@RequestMapping(value="/usuario", method=RequestMethod.POST)
	@PostMapping("usuario")
	public UsuarioResponse updateOrSave(@RequestBody @Valid UsuarioRequest usuarioReq) {
		Usuario usuario=mapper.map(usuarioReq, Usuario.class);
		String token = getToken(usuario.getName());
		usuario.setToken(token);
		Usuario updatedUsuario= service.save(usuario);
		UsuarioResponse usuarioRes=mapper.map(updatedUsuario, UsuarioResponse.class);
		return usuarioRes;
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
