package designPatterns.src.creational_design_pattern.factory.factorySanket.better;

public class CoffeeProcessor {
    public Coffee prepareCoffee(String type){
        Coffee coffee = new CoffeeFactory().getCoffee(type);
        return coffee;
    }
}
/**
 * with this particular implementation, creation of object how it is created conditionally
 * is not somethign i am liking
 * this code is vioalting OCP
 * now coffee processor is violating DIP as well
 * becasue it is direcl;ty dependeent on espressol, latte and everything
 * now the thing is as this is object creation so at some point of time we have to use the new kweyword
 * what we shuld try to do is, we shiuld kind of try to defer it and put all the creation logic at one place
 * we try to preapre kind of a fctory class
 *
 *
 *
 */
