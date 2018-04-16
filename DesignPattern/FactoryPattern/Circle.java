package DesignPattern.FactoryPattern;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

    public void draw2() {
        System.out.println("Inside Circle::draw() method.");
    }
}
