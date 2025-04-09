package socialnetworkingservice;

import socialnetworkingservice.model.*;
import socialnetworkingservice.service.UserService;
import socialnetworkingservice.service.UserServiceImpl;
import tictactoe.model.User;

import java.awt.*;

public class SocialNetworkingDemo {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        Account account = new UserProfile(1, "Nikhil", "abc@def", "1234");
        account.logIn();
        Account account1 = new UserProfile(3, "Nikhil_1", "abc@def", "1234");
        Account account2 = new UserProfile(2, "Nikhil_2", "abc@def", "1234");

        Post textPost  = new Text("1", "News", "1234", "This is a Text Post");
        Post imagePost = new Images("1", "Image", "1234", "This is a Image");

        userService.createPost((UserProfile) account, (Text) textPost);



    }


}
