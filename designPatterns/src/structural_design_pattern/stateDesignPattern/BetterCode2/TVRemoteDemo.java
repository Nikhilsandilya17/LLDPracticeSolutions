package structural_design_pattern.stateDesignPattern.BetterCode2;

public class TVRemoteDemo {
    public static void main(String[] args) {
        TVRemoteBasic tvRemoteBasic = new TVRemoteBasic();
        tvRemoteBasic.pressPowerButton(); // Switch ON
        tvRemoteBasic.pressPowerButton(); // Switch OFF
        tvRemoteBasic.pressPowerButton(); // Switch ON again
    }
}
/*
an interface State controlling the states.
which is having functionality like pressPowerButton()
and two states implementing it
In TVRemote class we are setting the initial state as OFF
and TVRemote will have a state
also TVRemote will have functionality of pressPowerButton()
in this method, we will state.pressPowerButton(this)
where this represents current state object
 */
