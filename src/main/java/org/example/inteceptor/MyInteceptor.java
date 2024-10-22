package org.example.inteceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.AccessLog;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class MyInteceptor implements HandlerInterceptor {

    private ThreadLocal<AccessLog> threadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AccessLog accessLog = new AccessLog();
        threadLocal.set(accessLog);
        String uri = request.getRequestURI();
        String method = request.getMethod();
        accessLog.setRequestUri(uri);
        accessLog.setRequestMethod(method);
        String ip = request.getRemoteAddr();
        String realIp = request.getHeader("X-Forwarded-For");
        if (realIp == null || realIp.length() == 0) {
            accessLog.setRealIp(ip);
        }
        else {
            accessLog.setRealIp(realIp);
        }
        if(handler instanceof HandlerMethod) {
            //设置处理函数
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            String methodName = handlerMethod.getMethod().getName();
            accessLog.setHandlerMethod(methodName);
        }
        else {
            accessLog.setHandlerMethod("");
        }
        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        AccessLog accessLog = threadLocal.get();
//        accessLog.setHttpStatus(response.getStatus());
//    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AccessLog accessLog = threadLocal.get();
        accessLog.setHttpStatus(response.getStatus());
        log.info(accessLog.toString());
        threadLocal.remove();
    }

}
