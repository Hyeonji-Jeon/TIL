package com.exam.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Rest 방식의 전역 예외처리
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler
                   extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler({ UserNotFoundException.class })
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		// 에러메시지 저장할 ErrorDetails 생성
		ErrorDetails errorDetails =
				new ErrorDetails(ex.getMessage(), LocalDate.now(), request.getDescription(false));
		
	   return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
}

// 에러메시지 저장 클래스
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
class ErrorDetails{
	
	String message;
	LocalDate timestamp;
	String detail;
	
}




