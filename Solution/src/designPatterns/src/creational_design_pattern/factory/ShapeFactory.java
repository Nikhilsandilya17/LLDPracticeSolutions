package designPatterns.src.creational_design_pattern.factory;

public class ShapeFactory {
    public Shape getShape(ShapeEnum input){

        //Point to note: getShape() inside ShapeFactory returns object of type 'Shape'

        return switch (input) {
            case CIRCLE -> new Circle();
            case RECTANGLE -> new Rectangle();
            default -> throw new IllegalArgumentException();
        };
    }
}
