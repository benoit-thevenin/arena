package fr.phoenyx.arena.advices.battle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.battle.SheetException;

@ControllerAdvice
public class SheetAdvice {

    @ResponseBody
    @ExceptionHandler(SheetException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String genericEntityHandler(SheetException exception) {
        return exception.getMessage();
    }
}
