package com.ctw.workstation.Simple;

import com.ctw.workstation.External.ExternalApi;
import com.ctw.workstation.config.WiremockResource;
import com.ctw.workstation.config.commodoreTestConfig;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@QuarkusTestResource(WiremockResource.class)
class HelloAcacdemyOtherTest {

    @Inject
    HelloAcacdemyOther helloAcacdemyOther;

    @Test
    @DisplayName("Say hello with valid name")
    void say_Hello_With_Valid_Name() {

        //Given

        /*
        String name = "banana";
        stubFor("/external/Hello").willReturn(aResponse()).withHeader("ContentType","application/json").withStatus(200).withBody(\"message\":\"Hello Rennan\");
                //^ mal escrito mas a ideia é esta

        //When

        String actualHello = helloAcacdemyOther.sayHello(name);

        //Then

        assertThat(actualHello).isNotNull();

         */

    }

}