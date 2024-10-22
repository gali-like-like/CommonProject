package org.example.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String msg;
    private Object data;

    private Result(Integer id, String msg, Object data) {
        this.id = id;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    public static Result success(String msg,Object data) {
        return new Result(1, msg, data);
    }

    public static Result error(String msg) {
        return new Result(-1, msg, null);
    }
}
