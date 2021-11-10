package com.evaluacion.ntt;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.evaluacion.ntt.api.UsuarioController;
import com.evaluacion.ntt.api.ValidationController;
import com.evaluacion.ntt.dto.LoginRequest;
import com.evaluacion.ntt.dto.LoginResponse;

@SpringBootTest
class UsuariosApplicationTests {
	@Autowired
	UsuarioController usuariocontroller;
	@Autowired
	ValidationController validacionController;
	@Test
	public void contextLoads() throws Exception {
		assertThat(usuariocontroller).isNotNull();
		assertThat(validacionController).isNotNull();
	}
	
	@Test
	public void loginTest() throws Exception {
		LoginRequest loginReq=new LoginRequest("nivanovich","Hunter22");
		LoginResponse loginRes=validacionController.validar(loginReq);
		assertThat(loginRes.getToken()).isNotNull();
	}

}
