package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.handlers;

import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.dto.RequestDTO;

public interface RequestHandler {
    void handle(RequestDTO requestDTO); //What to do in a handler can go here
}
