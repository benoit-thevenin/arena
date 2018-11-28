package fr.phoenyx.arena.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.PlayerException;

@ControllerAdvice
public class PlayerAdvice {

    @ResponseBody
    @ExceptionHandler(PlayerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String genericEntityHandler(PlayerException exception) {
        return exception.getMessage();
    }
}
