package designPatterns.src.structural_design_pattern.stateDesignPattern.ProblematicCode1;

public class MediaPlayer {

    private String mediaPlayerState;

    public MediaPlayer() {
        mediaPlayerState = "PAUSED"; // Can be Paused, Playing, or Stopped
    }

    public void pressPlay(){
        if(mediaPlayerState.equalsIgnoreCase("PAUSED")){
            System.out.println("Media Player is now Playing.");
            mediaPlayerState = "PLAYING";
        }
        else {
            System.out.println("Media Player is already Playing.");
        }
    }

    /*
    State Pattern solves:
    Violation of Single Responsibility Principle: Logic for different states is put into separate classes.
    Violation of Open/Closed Principle: You can add new states without modifying existing code.
     */

    public void pressPause(){
        if(mediaPlayerState.equalsIgnoreCase("PLAYING")){
            System.out.println("Media Player is now Paused.");
            mediaPlayerState = "PAUSED";
        }
        else {
            System.out.println("Media Player is already Paused.");
        }
    }
}
