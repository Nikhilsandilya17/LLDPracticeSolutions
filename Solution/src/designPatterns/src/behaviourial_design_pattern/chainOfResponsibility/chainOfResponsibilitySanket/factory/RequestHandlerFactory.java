package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.factory;

import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.handlers.*;
import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.service.TokenServiceImpl;

public class RequestHandlerFactory {
    public static RequestHandler getHandlersForCreateTodo() {
        return new ValidateParamsHandler(
                new ValidateBodyHandlers(
                        new AuthorizationHandlers(
                                new AuthenticationHandlers(new FinishingHandler(), new TokenServiceImpl())
                        )
                )
        );
    }

    //Similarly we can create new factories of handlers
    public static RequestHandler getHandlersForUpdateTodo() {
        return new ValidateParamsHandler(
                new ValidateBodyHandlers(
                        new AuthorizationHandlers(
                                new AuthenticationHandlers(new FinishingHandler(), new TokenServiceImpl())
                        )
                )
        );
    }
}
