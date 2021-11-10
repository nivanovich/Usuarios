package com.evaluacion.ntt.dto;

import lombok.Data;

@Data
public class LoginResponse {
	private String usuario;
	private String pasword;
	private String token;
}
