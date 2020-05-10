package org.example.service;

import org.example.model.Request;
import org.example.model.SavedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@Qualifier("defaultResponseService")
@ConditionalOnProperty(
        value = "config.enabled",
        havingValue = "false")
public class DefaultResponseService<T> implements ResponseService<T> {

    private final SavedResponseAccessor<T> savedResponseAccessor;

    @Autowired
    public DefaultResponseService(@Qualifier("defaultSavedResponseAccessor") SavedResponseAccessor<T> savedResponseAccessor) {
        this.savedResponseAccessor = savedResponseAccessor;
    }

    @Override
    public T processResponse(Supplier<T> responseSupplier, Request request) {
        SavedResponse<T> savedResponse = savedResponseAccessor.getSavedResponse(request.getId());
        if (savedResponse != null) {
            return savedResponse.getSavedResponse();
        }
        return responseSupplier.get();
    }
}
