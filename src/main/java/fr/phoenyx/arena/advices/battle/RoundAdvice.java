package fr.phoenyx.arena.advices.battle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.battle.RoundException;

@ControllerAdvice
public class RoundAdvice {

    @ResponseBody
    @ExceptionHandler(RoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String genericEntityHandler(RoundException exception) {
        return exception.getMessage();
    }
}
