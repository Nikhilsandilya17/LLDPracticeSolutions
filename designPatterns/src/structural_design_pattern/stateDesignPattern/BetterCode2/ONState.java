package structural_design_pattern.stateDesignPattern.BetterCode2;

public class ONState implements State{

    @Override
    public void pressPowerButton(TVRemoteBasic tvRemoteBasic) {
        System.out.println("TV is switched OFF");
        tvRemoteBasic.setState(new OFFState());
    }
}
