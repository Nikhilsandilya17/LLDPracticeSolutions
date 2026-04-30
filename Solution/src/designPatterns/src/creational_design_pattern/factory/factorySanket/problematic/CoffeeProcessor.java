package designPatterns.src.creational_design_pattern.factory.factorySanket.problematic;

public class CoffeeProcessor {
    public Coffee prepareCoffee(String type){
        if(type.equalsIgnoreCase("Cappucino")){
            return new Cappucino();
        } else if(type.equalsIgnoreCase("Latte")){
            return new Latte();
        }
        else if(type.equalsIgnoreCase("Espresso")){
            return new Espresso();
        }
        return null;
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
 * one problem with this approach is what if in expresso we do not need milk
 * i mean some kind of modification in implementation
 * so latte requries one more arguement
 *
 * here we can counter that this implementation logic we can put in separate class
 * but still we cant get rid of new keyword
 *
 *
 *
 *
 */
