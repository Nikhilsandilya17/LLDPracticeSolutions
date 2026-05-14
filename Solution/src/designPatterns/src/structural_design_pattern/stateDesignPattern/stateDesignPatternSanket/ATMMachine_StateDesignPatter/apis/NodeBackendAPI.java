package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.apis;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.DTO.CreateTransactionRequestDto;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.DTO.GetATMAmountRequestDto;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.DTO.UpdateATMStateRequestDto;

public class NodeBackendAPI implements BackendAPI{
    //This should be only responsible for connecting to the backend and returning the response
    //In future if we want to migrate from Node server to python server
    //so this kind of design supports it, we can directly change the class referring node to python
    @Override
    public int createTransaction(CreateTransactionRequestDto createTransactionRequestDto) {
        //1. validations
        if(createTransactionRequestDto == null){
            throw new IllegalArgumentException("createTransactionRequestDto cannot be null");
        }
        //2. Connect to the backend
        //To mimic the backend call, lets return a new transactionId

        //3. return the response
        return (int) (Math.random()*100);
    }

    @Override
    public boolean updateState(UpdateATMStateRequestDto updateATMStateRequestDto) {
        //Assume that there is the implementation that calls the backend to update the state of ATM.
        //You might get a question that why are we updating state in backend, why only updating the State was not enough
        //i mean when we are completing initializing the transaction, why cant we just update the state, whats the need to updating in backend
        //because lets say we start a transaction, and then due to some issue or atm failure atm again came back to ready state
        //now user will again start, so technically there are 2 transactions running at the moment which violates our requirement
        //so we would like to restore what was the last state of atm was, so for this we need to persist it somewhere
        //from where we can get the last state
        return true;

    }

    @Override
    public int getATMAmount(GetATMAmountRequestDto getATMAmountRequestDto) {
        return 10000;
    }
}
