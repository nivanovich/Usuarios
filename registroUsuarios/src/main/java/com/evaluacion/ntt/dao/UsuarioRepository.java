package com.evaluacion.ntt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluacion.ntt.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
