package org.example.service;

import org.example.model.Response;
import org.example.model.SavedResponse;

public interface SavedResponseAccessor<T> {

    SavedResponse<T> getSavedResponse(int id);

}
