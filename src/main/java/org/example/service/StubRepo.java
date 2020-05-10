package org.example.service;

import org.example.model.BarResponse;
import org.example.model.FooResponse;
import org.example.model.SavedResponse;

class StubRepo {
    private final int id;

    public StubRepo(int id) {
        this.id = id;
    }

    public <T> SavedResponse<T> invoke() {
        switch (id) {
            case 1:
                return new SavedResponse<>((T) new FooResponse("saved foo"));
            case 2:
                return new SavedResponse<>((T) new BarResponse("saved bar"));
            default:
                return null;
        }
    }
}
