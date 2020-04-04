package com.deloitte.banking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import com.deloitte.banking.model.dtos.Error;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(NoAccountFoundException.class)
	public ResponseEntity<Error> handleNoAccountFoundException(RuntimeException e) {
		Error error = new Error();
		error.setErrorMessage(e.getMessage());
		error.setErrorCode(100);
		error.setType("Business Error");
		error.setStatusCd(HttpStatus.NOT_FOUND.value());
		error.setStackTrace(e.getStackTrace()[0]);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<Error> handleDuplicatePANEntryException(RuntimeException e) {
		Error error = new Error();
		error.setErrorMessage(e.getMessage());
		error.setErrorCode(101);
		error.setType("Business Error");
		error.setStatusCd(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setStackTrace(e.getStackTrace()[0]);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<Error> handleInsufficientBalanceException(RuntimeException e) {
		Error error = new Error();
		error.setErrorMessage(e.getMessage());
		error.setErrorCode(106);
		error.setType("Business Error");
		error.setStatusCd(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setStackTrace(e.getStackTrace()[0]);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
