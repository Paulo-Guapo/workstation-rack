package com.ctw.workstation.Simple;

import com.ctw.workstation.External.ExternalApi;
import com.ctw.workstation.External.ExternalRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class HelloAcacdemyOther {

    @Inject
    @RestClient
    ExternalApi externalApi;

    public String sayHello(String name) {
        if (name != null) {
            return externalApi.hello(new ExternalRequest(name)).message();
        }
        return externalApi.hello().message();
    }

}
