package org.example.model;

public interface Response {
    String getResponse();

    String getMessage();

    default String getMessageResponse() {
        return String.format("%s - %s", getMessage(), getResponse());
    }
}
