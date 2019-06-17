package designPatterns.factory;

public class DrawCircle implements DrawShape {
    @Override
    public void draw() {
        System.out.println("This is a Circle");
    }
}
