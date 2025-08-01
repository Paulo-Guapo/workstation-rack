package com.ctw.workstation.Simple;

public class ExternalMessageServiceImpl implements ExternalMessageService {

    //Carservice carservice; //alt+enter -> interface

    @Override
    public String sayHelloFromOuterSpace(String name) {
        return "Hello from outer Space " + name;
    }

    @Override
    public String sayHelloFromOuterSpace() {
        return "Hello from outer Space";
    }

    /*
    //criar constrotor para usar car service

    public void doSomething() {

        carservice.doSomething();

    }

     */

    @Override
    public void fazAlgo(){

        throw new UnsupportedOperationException("Cannot execute");

    }



}
