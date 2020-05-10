package org.example.service;

import org.example.model.Request;
import org.example.model.Response;

import java.util.function.Supplier;

public interface ResponseService<T> {

    T processResponse(Supplier<T> responseSupplier, Request request);

}
