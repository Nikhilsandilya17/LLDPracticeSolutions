package structural_design_pattern.stateDesignPattern.BetterCode2;

public class OFFState implements State{

    @Override
    public void pressPowerButton(TVRemoteBasic tvRemoteBasic) {
        System.out.println("TV is switched ON");
        tvRemoteBasic.setState(new ONState());
    }
}
