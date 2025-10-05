package designPatterns.src.structural_design_pattern.stateDesignPattern.BetterCode1;

public class PlayingState implements State {

    @Override
    public void play(MediaPlayer mediaPlayer) {
        System.out.println("Media is already playing.");
    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
        System.out.println("Media Player is now Paused.");
        mediaPlayer.setState(new PausedState());
    }
}
