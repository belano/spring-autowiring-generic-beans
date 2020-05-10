package org.example;

import org.example.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(
        value = "config.enabled",
        havingValue = "true",
        matchIfMissing = true)
public class AppConfiguration {

    @Bean
    @Qualifier("defaultSavedResponseAccessor")
    public SavedResponseAccessor<?> aSavedResponseAccessor() {
        return new DefaultSavedResponseAccessor<>();
    }

    @Bean
    @Qualifier("anotherSavedResponseAccessor")
    public SavedResponseAccessor<?> anotherSavedResponseAccessor() {
        return new AnotherSavedResponseAccessor<>();
    }

    @Bean
    @Qualifier("defaultResponseService")
    public ResponseService<?> aResponseService(@Qualifier("defaultSavedResponseAccessor") SavedResponseAccessor<?> savedResponseAccessor) {
        return new DefaultResponseService<>(savedResponseAccessor);
    }

    @Bean
    @Qualifier("anotherResponseService")
    public ResponseService<?> anotherResponseService(@Qualifier("anotherSavedResponseAccessor") SavedResponseAccessor<?> savedResponseAccessor) {
        return new AnotherResponseService<>(savedResponseAccessor);
    }

}
