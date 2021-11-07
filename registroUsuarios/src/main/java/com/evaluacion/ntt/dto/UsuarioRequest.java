package com.evaluacion.ntt.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import com.evaluacion.ntt.entity.Phone;

import lombok.Getter;
import lombok.Setter;

public class UsuarioRequest {
	@Getter @Setter private Long id;
	@Getter @Setter private String name;		    
	@Email
	@Getter @Setter private String email;
	@Pattern(regexp="^[A-Z]+[[a-z]*[0-9]{2}]*$", message="Password tiene formato incorrecto +")
	@Getter @Setter private String password;	
	@Getter @Setter List<Phone> phones;
	
}
