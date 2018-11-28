package fr.phoenyx.arena.advices.battle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.qos.logback.core.joran.spi.ActionException;

@ControllerAdvice
public class ActionAdvice {

    @ResponseBody
    @ExceptionHandler(ActionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String genericEntityHandler(ActionException exception) {
        return exception.getMessage();
    }
}
