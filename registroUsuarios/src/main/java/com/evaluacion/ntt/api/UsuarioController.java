package com.evaluacion.ntt.api;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.ntt.dto.UsuarioRequest;
import com.evaluacion.ntt.dto.UsuarioResponse;
import com.evaluacion.ntt.service.UsuarioService;
@RestController
public class UsuarioController {
	@Autowired
	UsuarioService service;	
	@RequestMapping(value="/usuario", method=RequestMethod.POST)
	@PostMapping("usuario")
	public UsuarioResponse updateOrSave(@RequestBody @Valid UsuarioRequest usuarioReq) {		

		UsuarioResponse usuarioRes= service.save(usuarioReq);
		
		return usuarioRes;
	}

	
}
