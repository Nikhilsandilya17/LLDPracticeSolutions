package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.service;

import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.dto.RequestDTO;

public interface TokenService {
    boolean validateToken(RequestDTO requestDTO);
}
