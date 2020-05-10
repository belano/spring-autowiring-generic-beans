package org.example;

import org.example.model.BarResponse;
import org.example.model.FooResponse;
import org.example.model.Request;
import org.example.service.ResponseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@TestPropertySource(properties = "config.enabled=false")
public class AppTest {

    @Autowired
    @Qualifier("defaultResponseService")
    private ResponseService<FooResponse> fooResponseService;

    @Autowired
    @Qualifier("anotherResponseService")
    private ResponseService<BarResponse> barResponseService;

    @Test
    void shouldInjectConcreteServiceInstances() {
        FooResponse fooResponse = fooResponseService.processResponse(FooResponse::new, new Request(1));
        System.out.println(fooResponse.getMessageResponse());

        BarResponse barResponse = barResponseService.processResponse(BarResponse::new, new Request(2));
        System.out.println(barResponse.getMessageResponse());

        FooResponse notFoundResponse = fooResponseService.processResponse(FooResponse::new, new Request(0));
        System.out.println(notFoundResponse.getMessageResponse());
    }

}
