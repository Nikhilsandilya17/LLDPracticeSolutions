package designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket.service;

import designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket.Iterator;
import designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket.iterators.UserIterator;
import designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket.repositories.UserRepository;
import designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket.repositories.UserRepositoryImpl;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    private final Iterator<List<String>> userIterator;


    public UserService() {
        this.userRepository = new UserRepositoryImpl();
        this.userIterator = new UserIterator(10);
    }

    public void getUsersOnPlatform(){
        //this.userRepository.findUsers(10, 1);
        while(userIterator.hasNext()){
            List<String> users = userIterator.next();
            System.out.println("Fetched users: "+ users);
        }
    }
}
/**
 * this.userRepository.findUsers(10, 1);
 * 1. here the service layer has to keep track of current page or current offset
 * 2. wherever this pagination is required we need to maintain offset there
 * 3. we dont know when to stop? we might have to write a custom logic to chekc if no more data is there
 *
 *
 */
/**
how does a normal paginated api look like
 lets say you have a get reuest
 GET /api/v1/products ? limit = 25 & offset = 50
 response
 {
    success: true,
    message: "Products fetched successfully",
   data: [....25 products here....],
   nextOffset: 75,
   totalProducts: 200
 }
this lack a fundamental info
 how does a client to know whether there is more data to fetch or not?
 in order to knwo , client has to mnuallt fetch the data and write a custom logic themselves
 this should not be a responsiblity of client
 if we can giove this info to clinet that whther there is something left or not


 so our coding impl should be in a way that we dont have to manage offset in service layer
 how can we improve this get endpoitn?

 in order to improve this api
 the succsss, msg propert rmain same
 in response data instead of returnign array of responses
 the data is also an object lets say
 and inside this data u tell couple of properties
    data: {
 liimit:25,
 offset:50
 hasNext:true
 response: [....25 products here....]
    }
 }

 now client already know which limit and offset is called
 we can add mroe data like nextLimit, nextOffset
 we are able to introduce couple of properties which can actually tell use whether there is more data availbel or not
 and thats brings us to onre more DP that is iterator DP
how does it work?
 whenever there is a situation where u have to conusme some partial paginated kind of data
 we should try to write an interface 'iterator'

 there is goinf to be one function hasNext()

 interface iterator{
    boolean hasNext();
    List<String> getNext();
 }

 for coinbase problem
 class SequentailIterator imeplements Iterator{


 }

 class RandomizedIterator implements Iterator{


 }

 class JumperIteraotr implements Iterator{


 }

 how do we know that if a structure/DS supports iterator?
 how can we force a strcuture to support iterator?


 class LinkedList implements Iterable{ - ans1

 }

 interface Iterable{ - ans2
    Iterator getIterator();
 }
 */
/**
 * problem:
 * we have a user repo with us and now we are going to access userRepo from our service layer
 *
is there any problem in calling fndUser directly from service layer?
 the bigest problem when we are direclty gettign data
 - this user service

 */