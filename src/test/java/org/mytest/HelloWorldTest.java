package org.mytest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest
{
    @Test
    void testSayHello() {
        HelloWorld hw = new HelloWorld();
        String msg = hw.sayHello("Stranger");
        assertEquals("Hello Stranger, how are you?", msg);
    }
}
