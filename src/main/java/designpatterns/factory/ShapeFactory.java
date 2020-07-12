package designpatterns.factory;

public class ShapeFactory {
    public  static  DrawShape getObject(Shapes type) {
        DrawShape drawShape = null;
        switch (type) {
            case LINE:
                drawShape = new DrawLine();
                break;
            case CIRCLE:
                drawShape = new DrawCircle();
                break;
            case RECTANGLE:
                drawShape = new DrawRecatngle();
                break;
        }
        return drawShape;
    }
}
