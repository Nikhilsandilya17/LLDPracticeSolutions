package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.dto;

import java.util.Optional;

public class RequestDTO {
    private String requestType;
    private String route;
    private Optional<Object> body;
    public RequestDTO(String requestType, String route, Optional<Object> body) {
        this.requestType = requestType;
    }
}
