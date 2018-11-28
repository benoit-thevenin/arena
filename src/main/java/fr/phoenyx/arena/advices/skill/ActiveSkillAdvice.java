package fr.phoenyx.arena.advices.skill;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.skill.ActiveSkillException;

@ControllerAdvice
public class ActiveSkillAdvice {

    @ResponseBody
    @ExceptionHandler(ActiveSkillException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String genericEntityHandler(ActiveSkillException exception) {
        return exception.getMessage();
    }
}
