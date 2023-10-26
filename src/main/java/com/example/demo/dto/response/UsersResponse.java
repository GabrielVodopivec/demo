package com.example.demo.dto.response;

import com.example.demo.entities.User;

import java.util.List;

public class UsersResponse {
    private int status;
    private String message;
    private List<?> result;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }
}