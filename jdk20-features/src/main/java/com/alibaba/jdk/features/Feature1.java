package com.alibaba.jdk.features;

/**
 *
 */
public class Feature1 {

    public void recordPattern() {
        Shape shape = new Circle(2);
        switch (shape) {
            case Circle(int radius) -> System.out.println("radius: " + radius);
            case Square(int side) -> System.out.println("side: " + side);
            case Rectangle(int len, int width) -> System.out.println("length: " + len + ", width: " + width);
             default -> System.out.println("unknown");
        }
    }


    public interface Shape {

    }

    record Circle(int radius) implements Shape {

    }

    record Square(int side) implements Shape {

    }

    record Rectangle(int len, int width) implements Shape {

    }
}
