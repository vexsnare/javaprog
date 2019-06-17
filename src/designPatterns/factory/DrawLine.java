package designPatterns.factory;

public class DrawLine implements DrawShape {
    @Override
    public void draw() {
        System.out.println("This is a Line");
    }
}
