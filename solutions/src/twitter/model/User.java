package twitter.model;

import twitter.service.UserService;

public class User extends Account {

    public User(int id) {
        super(id);
    }

    private UserService userService;


    @Override
    protected void unfollowAccount(Account account) {

    }

    @Override
    protected void followAccount(Account account) {
        userService.followAccount(account);
    }


}
