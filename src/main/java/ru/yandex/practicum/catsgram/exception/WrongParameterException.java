package ru.yandex.practicum.catsgram.exception;

public class WrongParameterException extends RuntimeException {
    private final String parameter;

    public WrongParameterException(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}