package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InivalidInputExeption extends RuntimeException{
    public InivalidInputExeption() {
    }

    public InivalidInputExeption(String message) {
        super(message);
    }

    public InivalidInputExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InivalidInputExeption(Throwable cause) {
        super(cause);
    }

    public InivalidInputExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
