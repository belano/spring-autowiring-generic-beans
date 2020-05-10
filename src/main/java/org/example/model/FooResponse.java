package org.example.model;

public class FooResponse implements Response {

    private final String message;

    public FooResponse() {
        this.message = "default message";
    }

    public FooResponse(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getResponse() {
        return "foo response";
    }
}
