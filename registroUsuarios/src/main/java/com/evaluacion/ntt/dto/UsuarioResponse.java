package com.evaluacion.ntt.dto;

import java.util.List;
import com.evaluacion.ntt.entity.Phone;

import lombok.Data;

@Data
public class UsuarioResponse {
	private Long id;
	private String name;
	private String email;
	private String password;	
	List<Phone> phones;
	private String token;
	
}
