package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.handlers;

import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.dto.RequestDTO;

public class ValidateBodyHandlers implements RequestHandler {
    private RequestHandler nextHandler;
    public ValidateBodyHandlers(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void handle(RequestDTO requestDTO) {
        System.out.println("Validate body handler is running");
        this.nextHandler.handle(requestDTO);
    }
}
