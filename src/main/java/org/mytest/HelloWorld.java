package org.mytest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String sayHello(String name) {
        logger.info("sayHellow is called with parameter [{}]", name);
        return "Hello " + name + ", how are you?";
    }

    public static void main(String[] args)
    {
        HelloWorld hw = new HelloWorld();
        String msg = hw.sayHello("Stranger");
        System.out.print(msg);
    }
}
