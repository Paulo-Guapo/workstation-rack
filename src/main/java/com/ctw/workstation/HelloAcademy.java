package com.ctw.workstation;

import com.ctw.workstation.Simple.ExternalMessageService;

public class HelloAcademy {

    ExternalMessageService externalMessageService;

    public HelloAcademy( ExternalMessageService externalMessageService) { // estava protected for some reason

        this.externalMessageService = externalMessageService;
    }

    public String sayHello(String name) {

        if(name != null){
            //return "Hello " + name;
            return externalMessageService.sayHelloFromOuterSpace(name);
        }else{
            //return "Hello";
            //return externalMessageService.sayHelloFromOuterSpace();
            String helloFromOuterSpace = null; // ctrl + alt + T para meter o try/catch
            try {
                helloFromOuterSpace = externalMessageService.sayHelloFromOuterSpace();
            } catch (Exception e) {
                //throw new RuntimeException(e);
                return "coisas estao mal";
            }

            externalMessageService.fazAlgo();

            return helloFromOuterSpace + " Academy";
        }

    }

}
