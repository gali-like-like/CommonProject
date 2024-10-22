package org.example.entity;

import lombok.Data;

@Data
public class AccessLog {
    private String realIp;
    private String requestMethod;
    private String requestUri;
    private String handlerMethod;
    private Integer httpStatus;

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d", realIp, requestMethod, requestUri, handlerMethod, httpStatus);
    }
}
