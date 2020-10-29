package com.example.jdbctest;

import lombok.Data;

@Data
public class AjaxResponse {
    private boolean isok;
    private int code; //200,400,500
    private String message;
    private Object data;

    public AjaxResponse(boolean isok, int code, String message, Object data) {
        this.isok = isok;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public AjaxResponse() {
    }
}
