package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.DTO.UpdateATMStateRequestDto;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.apis.BackendAPI;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.apis.NodeBackendAPI;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.enums.ATMState;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.state.ReadyForTransactionState;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.state.State;

public class ATM {
    private final String atmId;
    private State state;
    private final BackendAPI backendAPI;

    public ATM(String atmId, ATMState atmState) {
        this.atmId = atmId;
        this.backendAPI = new NodeBackendAPI();
        this.state = new ReadyForTransactionState(this, new NodeBackendAPI());
    }

    public String getAtmId() {
        return atmId;
    }

    // Q. Who should be responsible for changing the state of ATM?
    //ATM class itself should own that method to change ATM state, as ATM contains state (line 10)
    public void changeState(State atmState) {
        this.state = atmState;
        //now call the server to persist the state on the server side
        this.backendAPI.updateState(new UpdateATMStateRequestDto(this.atmId, new))

    }

}
