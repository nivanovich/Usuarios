package com.evaluacion.ntt.api;
import com.evaluacion.ntt.entity.Usuario;
import com.evaluacion.ntt.service.UsuarioService;
import com.evaluacion.ntt.dto.UsuarioRequest;
import com.evaluacion.ntt.dto.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import org.dozer.Mapper;
@RestController
public class UsuarioApi {
	@Autowired
	UsuarioService service;
	@Autowired
	Mapper mapper;
	@RequestMapping(value="/usuario", method=RequestMethod.POST)
	public UsuarioResponse updateOrSave(@RequestBody @Valid UsuarioRequest usuarioReq) {
		Usuario usuario=mapper.map(usuarioReq, Usuario.class);
		Usuario updatedUsuario= service.save(usuario);
		UsuarioResponse usuarioRes=mapper.map(updatedUsuario, UsuarioResponse.class);
		return usuarioRes;
	}
}
