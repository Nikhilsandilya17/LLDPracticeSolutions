package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.handlers;

import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.dto.RequestDTO;
import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.service.TokenService;

public class AuthenticationHandlers implements RequestHandler{
    /**
     * Shall we do this
     * private final AuthorisationHandler nextHandler
     * No, ideally this should be decided at runtime
     * and also violation of DIP
     * @param requestDTO
     */

    private final RequestHandler nextHandler;
    private final TokenService tokenService;
    public AuthenticationHandlers(RequestHandler nextHandler, TokenService tokenService) {
        this.nextHandler = nextHandler;
        this.tokenService = tokenService;
    }

    @Override
    public void handle(RequestDTO requestDTO) {
        //above the next handler call, whatever is written is executed before
        this.tokenService.validateToken(requestDTO);
        System.out.println("Authentication handler is running");
        this.nextHandler.handle(requestDTO);
        //below the handler, whatever is executed after the next handler
    }
}
