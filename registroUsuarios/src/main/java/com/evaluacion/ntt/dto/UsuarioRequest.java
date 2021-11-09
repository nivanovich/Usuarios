package com.evaluacion.ntt.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import com.evaluacion.ntt.entity.Phone;
import lombok.Data;

@Data
public class UsuarioRequest {
	 private Long id;
	 private String name;		    
	 @Email
	 private String email;
	 @Pattern(regexp="^[A-Z]+[[a-z]*[0-9]{2}]*$", message="Password tiene formato incorrecto +")
	 private String password;	
	 List<Phone> phones;
	 private String token;
	
}
