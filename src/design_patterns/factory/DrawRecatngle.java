package design_patterns.factory;

public class DrawRecatngle implements DrawShape {
    @Override
    public void draw() {
        System.out.println("This is a Rectangle");
    }
}
