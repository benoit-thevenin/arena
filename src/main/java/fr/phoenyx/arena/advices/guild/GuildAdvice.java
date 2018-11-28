package fr.phoenyx.arena.advices.guild;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.guild.GuildException;

@ControllerAdvice
public class GuildAdvice {

    @ResponseBody
    @ExceptionHandler(GuildException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String genericEntityHandler(GuildException exception) {
        return exception.getMessage();
    }
}
