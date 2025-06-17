package com.gini.error.handler;

import static org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON_VALUE;

import com.gini.error.exceptions.NegativeQuantityException;
import com.gini.error.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NegativeQuantityException.class)
    public ProblemDetail handleNegativeQuantityError(NegativeQuantityException ex) {
        log.error("ERROR: ", ex);
        //        return new Error()
        //                .detail(ex.getMessage())
        //                .instance(ex.getMessage())
        //                .title(HttpStatus.BAD_REQUEST.getReasonPhrase())
        //                .status(HttpStatus.BAD_REQUEST.value());

        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(
            produces = APPLICATION_PROBLEM_JSON_VALUE) // because I used ProblemDetail it will
    // automatically
    // produce application/json+problem
    public ProblemDetail handleNotFound(NotFoundException ex) {
        log.error("ERROR: ", ex);

        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
