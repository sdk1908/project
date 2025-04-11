package com.crud.rest.entity;

public class Response<T> {
    private String message;
    private T Data;

    public Response(String message, T data) {
        this.message = message;
        Data = data;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return Data;
    }
}
