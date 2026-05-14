package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.service;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.DTO.GetATMAmountRequestDto;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.apis.BackendAPI;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.apis.NodeBackendAPI;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.ATM;

public class CashDispenseServiceImpl implements CashDispenserService {
    private final BackendAPI backendAPI; //composition of BackendAPI class

    public CashDispenseServiceImpl() {
        this.backendAPI = new NodeBackendAPI();
    }

    public void dispenseCash(ATM atm, int amount) {
        //to dispense the cash, there must be a API call
        //to make a API call there must be a composition
        int atmAmount = this.backendAPI.getATMAmount(new GetATMAmountRequestDto(atm.getAtmId()));
        if(atmAmount < amount) {
            throw new RuntimeException("ATM does not have enough money");
        }
        System.out.println("Dispensing cash: " + amount);
    }
}
