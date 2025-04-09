package socialnetworkingservice.model;

import twitter.model.User;

import java.util.List;

public class UserProfile extends Account{

    public UserProfile(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    private String bioContent;
    private List<UserProfile> friends;

    public String getBioContent() {
        return bioContent;
    }

    public void setBioContent(String bioContent) {
        this.bioContent = bioContent;
    }

    public List<UserProfile> getFriends() {
        return friends;
    }

    public void setFriends(List<UserProfile> friends) {
        this.friends = friends;
    }

    @Override
    public void logIn() {
        System.out.println("User loggedIn");
    }

    @Override
    public void logOut() {
        System.out.println("User loggedOut");
    }



}
