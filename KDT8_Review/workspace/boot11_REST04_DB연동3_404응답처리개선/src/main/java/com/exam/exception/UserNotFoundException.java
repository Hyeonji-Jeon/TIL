package com.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
    Exception을 상속받지 않고 RuntimeException 상속 받음.
    이유는 RuntimeException 는 compile unchecked 이기 때문에
    예외처리가 필요없음.

*/

// 기본적으로 500 에러가 발생됨. 404 변경해야 됨.
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message) {
		super(message);
	}
}
