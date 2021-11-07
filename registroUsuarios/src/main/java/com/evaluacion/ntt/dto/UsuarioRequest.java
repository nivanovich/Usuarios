package com.evaluacion.ntt.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import com.evaluacion.ntt.entity.Phone;

public class UsuarioRequest {
	private Long id;
	private String name;		    
	@Email
	private String email;
	@Pattern(regexp="^[A-Z]+[[a-z]*[0-9]{2}]*$", message="Password tiene formato incorrecto +")
	private String password;	
	List<Phone> phones;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}
