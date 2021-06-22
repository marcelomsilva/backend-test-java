package br.com.marcelomsilva.backendtestjava.config.handler;

import br.com.marcelomsilva.backendtestjava.dto.ErrorDto;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.IllegalTransactionStateException;
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
    @ExceptionHandler({NoSuchElementException.class, UsernameNotFoundException.class})
    public ErrorDto noSuchElementHandle(NoSuchElementException exception) {
        return new ErrorDto(exception.getMessage());
    }


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorDto illegalArgumentException(IllegalArgumentException exception) {
        return new ErrorDto(exception.getMessage());
    }

}
