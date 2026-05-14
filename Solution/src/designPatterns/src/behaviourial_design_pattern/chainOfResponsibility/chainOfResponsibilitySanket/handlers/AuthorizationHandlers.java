package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.handlers;

import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.dto.RequestDTO;

public class AuthorizationHandlers implements RequestHandler {

    private RequestHandler nextHandler;
    public AuthorizationHandlers(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void handle(RequestDTO requestDTO) {
        System.out.println("Authorization handler is running");
        if(this.nextHandler != null) {
            this.nextHandler.handle(requestDTO);
        }
    }
}
