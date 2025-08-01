package com.ctw.workstation.Simple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class MathOperationsTest {
//
//    MathOperations mathOperations;
//
//    @BeforeAll
//    void init() {
//        mathOperations = new MathOperations();
//    }
//
//    @Test
//    public void devide_By_Zero(){
//
//        //assertThrows(ArithmeticException.class, () -> mathOperations.divide(10,5));
//        assertThrows(ArithmeticException.class, () -> mathOperations.divide(0,0)); // nao sei o que se passa(functions ver)

//    }
//
//    public static Stream<Arguments> add_Numbers() {
//        return Stream.of(
//                Arguments.of(0, 0, 0),
//                Arguments.of(2, 1, 1),
//                Arguments.of(4, 2, 2),
//                Arguments.of(-4, -2, -2)
//        );
//    }

//
//    @ParameterizedTest
//    @MethodSource()
//    public void add_Numbers(int a, int b, int c){
//
//        assertAll(
//                () -> assertEquals(a, mathOperations.add(b, c), "Method shoud add the two numbers?")
//        );
//
//        //assertEquals(10, mathOperations.add(5, 5));
//
//    }
//
//
//
//}