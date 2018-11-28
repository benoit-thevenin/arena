package fr.phoenyx.arena.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.TeamException;

@ControllerAdvice
public class TeamAdvice {

    @ResponseBody
    @ExceptionHandler(TeamException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String genericEntityHandler(TeamException exception) {
        return exception.getMessage();
    }
}
