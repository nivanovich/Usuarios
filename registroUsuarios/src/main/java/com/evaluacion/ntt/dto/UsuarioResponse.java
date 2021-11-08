package com.evaluacion.ntt.dto;

import java.util.List;
import com.evaluacion.ntt.entity.Phone;

import lombok.Getter;
import lombok.Setter;
public class UsuarioResponse {
	@Getter @Setter private Long id;
	@Getter @Setter private String name;
	@Getter @Setter private String email;
	@Getter @Setter private String password;	
	@Getter @Setter List<Phone> phones;
	@Getter @Setter private String token;
	
}
