package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.controller;

import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.dto.RequestDTO;
import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.factory.RequestHandlerFactory;
import designPatterns.src.behaviourial_design_pattern.chainOfResponsibility.chainOfResponsibilitySanket.models.Todo;

public class TodoController {
    /**
     * so are we going to have like
     * private AuthenticationHandler authenticationHandler
     * private AuthorisationHandler authorisationHandler
     * private ValidateBodyHandler validateBodyHandler
     * <p>
     * This is direct violation of DIP as we are directly depending on concrete classes
     *
     * @param requestDTO
     * @return
     */
    private Todo createTodo(RequestDTO requestDTO) {
//        List<RequestHandler> requestHandlers = List.of();
//
//        //Execute initial handlers
//        for(RequestHandler requestHandler : requestHandlers) {
//            requestHandler.handle(requestDTO);
//        }
//        //Return a new Todo
//        return new Todo();
        /**
         * ISSUES
         * 1. Your controller now knows how to call the next handler but ideally every handler should know how to call
         * the next handler (our requirement)
         *
         * 2. If request handling failed for any of the handler we have to return from controller which would required some additional
         * logic at controller end
         *
         * 3. also this is violating SRP, as our controller is handling how handlers should be called
         *
         */

        RequestHandlerFactory.getHandlersForCreateTodo().handle(requestDTO);
        return new Todo();
    }
}

