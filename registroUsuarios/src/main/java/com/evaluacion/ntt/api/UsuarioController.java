package com.evaluacion.ntt.api;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.ntt.dto.UsuarioRequest;
import com.evaluacion.ntt.dto.UsuarioResponse;
import com.evaluacion.ntt.service.UsuarioService;
@RestController
public class UsuarioController {
	@Autowired
	UsuarioService service;		
	@PostMapping("usuario")
	public UsuarioResponse updateOrSave(@RequestBody @Valid UsuarioRequest usuarioReq,@RequestHeader("Authorization") String token) {		
		usuarioReq.setToken(token);
		UsuarioResponse usuarioRes= service.save(usuarioReq);
		
		return usuarioRes;
	}

	
}
