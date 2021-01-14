package com.momentum.activeshop.advice;

import com.momentum.activeshop.exception.ActiveShopBadRequestException;
import com.momentum.activeshop.exception.ActiveShopResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ActiveShopExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ActiveShopResourceNotFoundException.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(ActiveShopBadRequestException.class)
    public void springHandleBadRequest(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
