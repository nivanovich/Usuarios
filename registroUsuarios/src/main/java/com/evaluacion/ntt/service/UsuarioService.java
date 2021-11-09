package com.evaluacion.ntt.service;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.ntt.dao.UsuarioRepository;
import com.evaluacion.ntt.dto.UsuarioRequest;
import com.evaluacion.ntt.dto.UsuarioResponse;
import com.evaluacion.ntt.entity.Usuario;
@Service
public class UsuarioService {
	@Autowired
	Mapper mapper;
	@Autowired
	UsuarioRepository dao;
	public UsuarioResponse save(UsuarioRequest usuarioReq) {	
		Usuario usuario=mapper.map(usuarioReq, Usuario.class);
		UsuarioResponse usuarioResponse=mapper.map(dao.saveAndFlush(usuario),UsuarioResponse.class);
		return usuarioResponse;
	}
}