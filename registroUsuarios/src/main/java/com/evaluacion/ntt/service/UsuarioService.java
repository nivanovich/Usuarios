package com.evaluacion.ntt.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.ntt.dao.UsuarioRepository;
import com.evaluacion.ntt.entity.Usuario;
@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository dao;
	public Usuario save(Usuario usuario) {	
			return dao.saveAndFlush(usuario);
	}
}