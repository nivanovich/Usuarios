package com.evaluacion.ntt.dto;

import lombok.Data;

@Data
public class LoginRequest {
	private String usuario;
	private String pasword;
	private String token;
}
