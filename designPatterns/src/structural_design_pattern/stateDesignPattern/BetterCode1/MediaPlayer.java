package structural_design_pattern.stateDesignPattern.BetterCode1;

public class MediaPlayer {
    private State state;

    public MediaPlayer(){
        this.state = new PausedState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressPlay() {
        state.play(this);
    }

    public void pressPause() {
        state.pause(this);
    }
}
