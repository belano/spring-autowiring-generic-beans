package org.example.model;

public class BarResponse implements Response {

    private final String message;

    public BarResponse() {
        this.message = "default message";
    }

    public BarResponse(String message) {
        this.message = message;
    }

    @Override
    public String getResponse() {
        return "bar response";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
