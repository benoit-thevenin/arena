package fr.phoenyx.arena.advices;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.utils.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Order(value = 0)
@Slf4j
public class GenericEntityAdvice {

    @ResponseBody
    @ExceptionHandler(GenericEntityException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String genericEntityHandler(GenericEntityException exception) {
        log.info(ExceptionUtils.exceptionStacktraceToString(exception));
        return exception.getMessage();
    }
}
