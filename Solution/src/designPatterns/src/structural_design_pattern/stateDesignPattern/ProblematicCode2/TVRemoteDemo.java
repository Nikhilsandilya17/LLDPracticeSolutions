package designPatterns.src.structural_design_pattern.stateDesignPattern.ProblematicCode2;

public class TVRemoteDemo {
    public static void main(String[] args) {
        TVRemoteBasic tvRemoteBasic = new TVRemoteBasic();
        tvRemoteBasic.pressPowerButton();
        tvRemoteBasic.pressPowerButton();
        tvRemoteBasic.pressPowerButton();
    }
}
