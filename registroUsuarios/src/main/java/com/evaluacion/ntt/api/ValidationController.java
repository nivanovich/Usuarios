package com.evaluacion.ntt.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.ntt.dto.LoginRequest;
import com.evaluacion.ntt.dto.LoginResponse;
import com.evaluacion.ntt.service.AuthorizationService;
@RestController
public class ValidationController {
	@Autowired
	AuthorizationService service;
	@PostMapping("validacion")
	public LoginResponse validar(@RequestBody @Valid LoginRequest loginReq) {
		
		LoginResponse loginResponse= service.validateUser(loginReq);
		return loginResponse;
		
	}
}
