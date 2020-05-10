package org.example.model;

public class SavedResponse<T> {
    private final T savedResponse;

    public SavedResponse(T savedResponse) {
        this.savedResponse = savedResponse;
    }

    public T getSavedResponse() {
        return savedResponse;
    }
}
