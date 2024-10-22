package org.example.exceptor;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Result;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalException{

//    sql异常的处理
    @ExceptionHandler(DataAccessException.class)
    public Result handlerSql(DataAccessException e) {
        log.error(e.getLocalizedMessage());
        return Result.error("sql异常");
    }

//    数据验证错误的处理
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result handleValidationExceptions(MethodArgumentNotValidException ex) {
        String error = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return Result.error(error);
    }

}
