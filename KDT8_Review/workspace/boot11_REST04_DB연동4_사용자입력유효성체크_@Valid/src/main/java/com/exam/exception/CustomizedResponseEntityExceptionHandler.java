package com.exam.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

// Rest 방식의 전역 예외처리
@RestControllerAdvice
@Slf4j
public class CustomizedResponseEntityExceptionHandler
                   extends ResponseEntityExceptionHandler {

	
	// 사용자 입력 데이터 유효성 예외 처리하는 메서드를 재정의함.
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		// 에러메시지 저장할 ErrorDetails 생성
		// ex.getMessage() 하면 출력되는 에러메시지가 너무 많다.
		// ex.getFieldError().getDefaultMessage() 하면 예외 발생된 개별 에러메시지만 출력됨.
		ErrorDetails errorDetails =
						new ErrorDetails(ex.getFieldError().getDefaultMessage(), LocalDate.now(), request.getDescription(false));
		log.error(errorDetails.toString());		
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);  // 400 에러
			   
	}
	
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




