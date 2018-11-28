package fr.phoenyx.arena.advices.skill;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.skill.PassiveSkillException;

@ControllerAdvice
public class PassiveSkillAdvice {

    @ResponseBody
    @ExceptionHandler(PassiveSkillException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String genericEntityHandler(PassiveSkillException exception) {
        return exception.getMessage();
    }
}
