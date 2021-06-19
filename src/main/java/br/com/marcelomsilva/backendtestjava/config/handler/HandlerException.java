package br.com.marcelomsilva.backendtestjava.config.handler;

import br.com.marcelomsilva.backendtestjava.dto.ErrorDto;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class HandlerException {

    final MessageSource messageSource;

    public HandlerException(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ErrorDto noSuchElementHandle(NoSuchElementException exception) {
        return new ErrorDto(exception.getMessage());
    }
}
