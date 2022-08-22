package ru.yandex.practicum.catsgram.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({WrongParameterException.class, WrongEmailException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleIncorrectParameterException(final Exception e) {
        return Map.of(e.getClass().getSimpleName(), e.getMessage());
    }

    @ExceptionHandler({PostNotFoundException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handlePostNotFoundException(final Exception e) {
        return Map.of(e.getClass().getSimpleName(), e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handlePostNotFoundException(final UserAlreadyExistException e) {
        return Map.of(e.getClass().getSimpleName(), e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleThrowable(final Throwable e) {
        return Map.of(e.getClass().getSimpleName(), e.getMessage());
    }
}