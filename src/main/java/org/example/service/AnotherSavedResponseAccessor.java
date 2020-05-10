package org.example.service;

import org.example.model.SavedResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("anotherSavedResponseAccessor")
@ConditionalOnProperty(
        value = "config.enabled",
        havingValue = "false")
public class AnotherSavedResponseAccessor<T> implements SavedResponseAccessor<T> {
    @Override
    public SavedResponse<T> getSavedResponse(int id) {
        return new StubRepo(id).invoke();
    }
}
