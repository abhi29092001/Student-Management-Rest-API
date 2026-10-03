package com.springboot.demo.exceptions;

public class StudentErrorResponse {
    // fields
    private int status;

    private String message;

    // constructors
    public StudentErrorResponse() {}

    public StudentErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // getters and setters

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
}
