package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.handlers;

import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.dto.RequestDTO;

public class ValidateParamsHandler implements  RequestHandler{
    private RequestHandler nextHandler;
    public ValidateParamsHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void handle(RequestDTO requestDTO) {
        System.out.println("Validate params handler is running");
        this.nextHandler.handle(requestDTO);
    }
}
