package designPatterns.src.structural_design_pattern.stateDesignPattern.ProblematicCode1;

public class MediaPlayerDemo {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.pressPlay();
        mediaPlayer.pressPlay();
        mediaPlayer.pressPause();

    }
}
