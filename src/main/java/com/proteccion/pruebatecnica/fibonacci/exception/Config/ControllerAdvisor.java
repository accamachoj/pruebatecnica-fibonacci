package com.proteccion.pruebatecnica.fibonacci.exception.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor {

    private static final String MESSAGE = "message";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception exception) {
        String messageException;
        String codMsg = exception.getMessage();
        switch (exception.getClass().toString()) {
            case "class com.proteccion.pruebatecnica.fibonacci.exception.NoDataFoundException":
                if(!codMsg.isEmpty()){
                	messageException = ExceptionResponse.getMensaje(codMsg);
                }else{
                	messageException = ExceptionResponse.getMensaje("msg_No_Data_Found");
                }
                return new ResponseEntity<>(Collections.singletonMap(MESSAGE, messageException),HttpStatus.NOT_FOUND);
            case "class com.proteccion.pruebatecnica.fibonacci.exception.BadRequestException":
            if(!codMsg.isEmpty()){
                messageException = ExceptionResponse.getMensaje(codMsg);
            }else{
                messageException = ExceptionResponse.getMensaje("msg_Bad_Request");
            }
            break;
            default:
                messageException = codMsg;
                log.info("Exception arrives: {} {}", exception.getClass().toString(), messageException);
                return new ResponseEntity<>(Collections.singletonMap(exception.getClass().toString(), messageException), HttpStatus.INTERNAL_SERVER_ERROR);
        }
		return new ResponseEntity<>(Collections.singletonMap(MESSAGE, messageException),HttpStatus.BAD_REQUEST);
    }

}