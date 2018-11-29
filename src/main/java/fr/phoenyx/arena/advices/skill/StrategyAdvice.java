package fr.phoenyx.arena.advices.skill;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.skill.StrategyException;
import fr.phoenyx.arena.utils.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Order(value = 0)
@Slf4j
public class StrategyAdvice {

    @ResponseBody
    @ExceptionHandler(StrategyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String genericEntityHandler(StrategyException exception) {
        log.info(ExceptionUtils.exceptionStacktraceToString(exception));
        return exception.getMessage();
    }
}