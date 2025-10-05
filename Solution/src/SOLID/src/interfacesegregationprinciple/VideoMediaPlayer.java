package SOLID.src.interfacesegregationprinciple;

public class VideoMediaPlayer implements MediaPlayer{

    @Override
    public void playAudio() {
        return;
    }

    @Override
    public void playVideo() {
        System.out.println("Playing video...");
    }

    @Override
    public void increaseBrightNess() {
        System.out.println("Increasing brightness...");
    }
}
