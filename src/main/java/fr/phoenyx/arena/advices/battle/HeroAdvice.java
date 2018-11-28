package fr.phoenyx.arena.advices.battle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.battle.HeroException;

@ControllerAdvice
public class HeroAdvice {

    @ResponseBody
    @ExceptionHandler(HeroException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String genericEntityHandler(HeroException exception) {
        return exception.getMessage();
    }
}
