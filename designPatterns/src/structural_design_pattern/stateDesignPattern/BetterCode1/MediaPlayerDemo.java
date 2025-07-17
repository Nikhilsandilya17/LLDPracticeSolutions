package structural_design_pattern.stateDesignPattern.BetterCode1;

public class MediaPlayerDemo {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.pressPlay();
        mediaPlayer.pressPlay();
        mediaPlayer.pressPause();
    }
}
