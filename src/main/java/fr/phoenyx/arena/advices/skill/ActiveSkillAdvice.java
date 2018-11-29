package fr.phoenyx.arena.advices.skill;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.skill.ActiveSkillException;
import fr.phoenyx.arena.utils.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Order(value = 0)
@Slf4j
public class ActiveSkillAdvice {

    @ResponseBody
    @ExceptionHandler(ActiveSkillException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String genericEntityHandler(ActiveSkillException exception) {
        log.info(ExceptionUtils.exceptionStacktraceToString(exception));
        return exception.getMessage();
    }
}
