package fr.phoenyx.arena.advices.item;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.item.BonusException;

@ControllerAdvice
public class BonusAdvice {

    @ResponseBody
    @ExceptionHandler(BonusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String genericEntityHandler(BonusException exception) {
        return exception.getMessage();
    }
}
