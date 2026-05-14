** Design a route handler / Design middleware

1. Are we looking for any db interactions?
2. Are we looking to setup REST apis ?
3. Are we looking for class impl or feature impl is also required? - Class structures are prefered

# Feature requirements:
1. Route handlers should be taking the incoming requests and validating the request body 
2. Route handlers should be able to validate the request params
3. Route handlers after validating body and params should be capable of doing the authentication
4. Once auth is done, route handlers can also do authorization
5. If the user is authorized then we continue to access the controller layer
6. Some route handlers might be in specific order and some might not be in specific order


Route mapper is a module that is responsible for mapping the incoming requests to its corresponding handler.

assume we have a single handler function

handler(Request request){
validate body,
validate params,
authenticate,
authorize,
controller
} - This directly violates SRP

an improvement would to be put all these logics in different functions
best way is to make different class

Note -> A route handler is capable of modifying request object before next handler gets it
every handler should be able to execute some logic and call the next handler expected. 
The logic must be executed before or after calling the next handler.
Handler arrangement can be diff for diff routes
In most common terminologies, we call these routes handlers as middlewares/ interceptors/ filters etc. depending on the framework we are using.

Middleware = Middleware are chain of functions where each function has access to the request, response and the next function in chain.
-> Design a OR based filter

Every handler class will be having 2 main components
1. Logic of the handler
2. access to next handler


# If we pass  new AuthorizationHandlers(null)
then there is no harm in doing a null check in code
but ideally we should always make a finishing handler which does nothing

There are lot of new keywords in TodoContrller while defining chain for Handlers
so we should make a factory
