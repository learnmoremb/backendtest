package com.example.pract.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistException extends BaseException{
    public AlreadyExistException(String message) {
        super(message);
    }
}
