package design_patterns.factory;

/**
 * Article:
 * https://dzone.com/articles/factory-method-design-pattern
 */
public class App {
    public static void main(String[] args) {
        DrawShape drawShape = ShapeFactory.getObject(Shapes.CIRCLE);
        if(null != drawShape) {
            drawShape.draw();
        }

        drawShape = ShapeFactory.getObject(Shapes.LINE);
        if(null != drawShape) {
            drawShape.draw();
        }

    }
}
