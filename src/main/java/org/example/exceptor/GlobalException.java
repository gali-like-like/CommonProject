package org.example.exceptor;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Result;
import org.springframework.dao.DataAccessException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
@Slf4j
public class GlobalException{

//    sql异常的处理
    @ExceptionHandler({DataAccessException.class})
    public Result handlerSql(DataAccessException e, HttpServletRequest request) {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        log.error("{},{},{}",method,uri,e.getMessage());
        return Result.error("sql异常");
    }

//    数据验证错误的处理
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result handleValidationExceptions(MethodArgumentNotValidException ex) {
        String error = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return Result.error(error);
    }

    // 资源找不到异常
    @ExceptionHandler(NoResourceFoundException.class)
    public Result handlerResourceNotFound(NoResourceFoundException e) {
        return Result.error("资源找不到");
    }
}
