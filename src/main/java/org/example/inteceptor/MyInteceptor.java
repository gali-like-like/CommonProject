package org.example.inteceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.nio.charset.Charset;

@Component
@Slf4j
public class MyInteceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString().trim();
        String method = request.getMethod();
        String ip = request.getRemoteAddr();
        String realIp = request.getHeader("x-forwarded-for");
        log.info("{}:{}:{}",ip,method,url);
        log.info("{}:{}:{}",realIp,method,url);
        return true;
    }

}
