package com.evaluacion.ntt.service;
import com.evaluacion.ntt.dao.UsuarioRepository;
import com.evaluacion.ntt.entity.Usuario;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository dao;
	public Usuario save(Usuario usuario){
//		List<Usuario> usuarios=dao.findAll();
//		
//		Iterator<Usuario> iterador=usuarios.iterator();
//		while(iterador.hasNext()) {
//			Usuario user=iterador.next();
//			if(user.getEmail().equalsIgnoreCase(usuario.getEmail())) {
//				throw new ResponseStatusException(
//				           HttpStatus.BAD_REQUEST, "El email ya existe en la base de datos");
//			}
//				
//		}
        return dao.saveAndFlush(usuario);
    }
}
