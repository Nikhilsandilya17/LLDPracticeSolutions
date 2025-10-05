package designPatterns.src.structural_design_pattern.stateDesignPattern.BetterCode1;

public class PausedState implements State{
    @Override
    public void play(MediaPlayer mediaPlayer) {
        System.out.println("Media Player is now Playing.");
        mediaPlayer.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
        System.out.println("Media is already paused.");
    }
}
