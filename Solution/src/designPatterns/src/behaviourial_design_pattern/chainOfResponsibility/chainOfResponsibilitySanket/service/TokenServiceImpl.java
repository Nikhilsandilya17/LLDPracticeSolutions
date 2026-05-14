package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.service;

import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.dto.RequestDTO;

public class TokenServiceImpl implements TokenService{

    @Override
    public boolean validateToken(RequestDTO requestDTO) {
        System.out.println("TokenService: Validating token");
        //fetches token from header
        //is token is not found return 404
        return true;
    }
}
