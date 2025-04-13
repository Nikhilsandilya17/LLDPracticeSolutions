package creational_design_pattern.factory;

import static creational_design_pattern.factory.ShapeEnum.CIRCLE;
import static creational_design_pattern.factory.ShapeEnum.RECTANGLE;

public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape(CIRCLE);
        shape.draw();
        Shape shape1 = shapeFactory.getShape(RECTANGLE);
        shape1.draw();

    }
}
