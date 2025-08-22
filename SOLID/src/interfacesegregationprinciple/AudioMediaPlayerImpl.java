package interfacesegregationprinciple;

public class AudioMediaPlayerImpl implements MediaPlayer{
    @Override
    public void playAudio() {
        System.out.println("Audio is playing");
    }

    @Override
    public void playVideo() {
        return;
    }

    @Override
    public void increaseBrightNess() {
        return;
    }
}
