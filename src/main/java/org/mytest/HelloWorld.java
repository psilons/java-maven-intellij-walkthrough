package org.mytest;

public class HelloWorld
{
    public String sayHello(String name) {
        return "Hello " + name + ", how are you?";
    }

    public static void main(String[] args)
    {
        HelloWorld hw = new HelloWorld();
        String msg = hw.sayHello("Stranger");
        System.out.print(msg);
    }
}
