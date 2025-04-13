package creational_design_pattern.factory;

import static creational_design_pattern.factory.ShapeEnum.RECTANGLE;

public class ShapeFactory {

    public Shape getShape(ShapeEnum input){
        switch (input){
            case CIRCLE:
                    return new Circle();
            case RECTANGLE:
                    return new Rectangle();
            default:
                throw new IllegalArgumentException();
        }
    }
}
