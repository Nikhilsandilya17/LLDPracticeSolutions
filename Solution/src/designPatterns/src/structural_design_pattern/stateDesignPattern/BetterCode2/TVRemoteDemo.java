package designPatterns.src.structural_design_pattern.stateDesignPattern.BetterCode2;

public class TVRemoteDemo {
    public static void main(String[] args) {
        TVRemoteBasic tvRemoteBasic = new TVRemoteBasic();
        tvRemoteBasic.pressPowerButton(); // Switch ON
        tvRemoteBasic.pressPowerButton(); // Switch OFF
        tvRemoteBasic.pressPowerButton(); // Switch ON again
    }
}
/*
an interface State controlling the states.
which is having functionality like pressPowerButton()
and two states implementing it
In TVRemote class we are setting the initial state as OFF
and TVRemote will have a state
also TVRemote will have functionality of pressPowerButton()
in this method, we will state.pressPowerButton(this)
where this represents current state object

The State Design Pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes.

-> Without this pattern:
You typically use large if-else or switch-case blocks in a single class.
As the number of states grows, the logic becomes complex and hard to maintain.

-> State Pattern solves:
Violation of Single Responsibility Principle: Logic for different states is put into separate classes.
Violation of Open/Closed Principle: You can add new states without modifying existing code.
Code Bloat: Reduces clutter from long conditional statements.

-> When to Use
When an object’s behavior depends on its state.
When you have complex conditional logic based on the object's state.

 */
