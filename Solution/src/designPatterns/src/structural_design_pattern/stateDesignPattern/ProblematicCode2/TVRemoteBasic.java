package designPatterns.src.structural_design_pattern.stateDesignPattern.ProblematicCode2;

public class TVRemoteBasic {
    private String state = "OFF";

    public void pressPowerButton() {
        if (state.equals("OFF")) {
            state = "ON";
            System.out.println("TV is now ON");
        } else {
            state = "OFF";
            System.out.println("TV is now OFF");
        }
    }
}
