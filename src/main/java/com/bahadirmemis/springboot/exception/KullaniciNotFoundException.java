package com.bahadirmemis.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 *  STEP 2.5 ALERT
 * */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class KullaniciNotFoundException extends RuntimeException{

    public KullaniciNotFoundException(String message) {
        super(message);
    }
}
