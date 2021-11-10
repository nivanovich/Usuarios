package com.evaluacion.ntt.dto;

import lombok.Data;

@Data
public class LoginRequest {
	private String usuario;
	private String pasword;
	private String token;
	public LoginRequest(String usuario, String pasword) {
		super();
		this.usuario = usuario;
		this.pasword = pasword;
	}
}
