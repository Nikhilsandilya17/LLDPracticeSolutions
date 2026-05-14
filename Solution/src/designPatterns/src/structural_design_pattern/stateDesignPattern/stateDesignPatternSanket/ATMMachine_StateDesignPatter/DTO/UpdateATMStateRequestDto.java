package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.DTO;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.enums.ATMState;

public class UpdateATMStateRequestDto {
    private final String atmId;
    private final ATMState atmState;

    public UpdateATMStateRequestDto(String atmId, ATMState atmState) {
        this.atmId = atmId;
        this.atmState = atmState;
    }

    public String getAtmId() {
        return atmId;
    }

    public ATMState getAtmState() {
        return atmState;
    }
}
