package creational_design_pattern.factory;

import static creational_design_pattern.factory.ShapeEnum.CIRCLE;
import static creational_design_pattern.factory.ShapeEnum.RECTANGLE;

public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape(CIRCLE);
        circle.draw();
        Shape rectangle = shapeFactory.getShape(RECTANGLE);
        rectangle.draw();

    }
}
