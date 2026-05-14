package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.handlers;

import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.dto.RequestDTO;

public class FinishingHandler implements RequestHandler{

    @Override
    public void handle(RequestDTO requestDTO) {
        System.out.println("Finishing handler is running");
    }
}
