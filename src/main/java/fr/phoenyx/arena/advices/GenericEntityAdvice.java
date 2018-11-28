package fr.phoenyx.arena.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.GenericEntityException;

@ControllerAdvice
public class GenericEntityAdvice {

    @ResponseBody
    @ExceptionHandler(GenericEntityException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String genericEntityHandler(GenericEntityException exception) {
        return exception.getMessage();
    }
}
