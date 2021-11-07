package com.evaluacion.ntt.error;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import java.util.List;


import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.server.ResponseStatusException;
@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> Exception(HttpServletRequest request, Exception e){
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(),e.getMessage().toString(), request.getRequestURI());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	
}
