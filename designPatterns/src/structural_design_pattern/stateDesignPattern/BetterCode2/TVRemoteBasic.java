package structural_design_pattern.stateDesignPattern.BetterCode2;

public class TVRemoteBasic {
    private State state;

    public TVRemoteBasic() {
        this.state = new OFFState(); // Initial state is OFF
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressPowerButton() {
        state.pressPowerButton(this);
    }

}
