package com.evaluacion.ntt.error;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import java.util.List;


import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.server.ResponseStatusException;
@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> Exception(HttpServletRequest request, Exception e){
		ErrorInfo errorInfo = null;
		if(e instanceof DataIntegrityViolationException) {
			if(((DataIntegrityViolationException) e).getRootCause().getMessage().contains("PUBLIC.USUARIO(EMAIL) VALUES 1"))
				errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(),"Correo ya esta registrado", request.getRequestURI());
		}else if(e instanceof MethodArgumentNotValidException) {
			if(e.getMessage().contains("default message [debe ser una dirección de correo electrónico con formato correcto]")) {
				errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(),"Formato de correo no es valido", request.getRequestURI());
			}
			if(e.getMessage().contains("default message [Password tiene formato incorrecto +]")) {
				errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(),"Formato de password no es valido", request.getRequestURI());
			}
		}
		else 
			errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(),e.getMessage().toString(), request.getRequestURI());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	
}
