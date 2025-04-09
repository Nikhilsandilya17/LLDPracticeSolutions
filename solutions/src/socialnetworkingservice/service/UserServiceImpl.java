package socialnetworkingservice.service;


import socialnetworkingservice.model.Post;
import socialnetworkingservice.model.Text;
import socialnetworkingservice.model.UserProfile;

public class UserServiceImpl implements UserService{


    @Override
    public void createPost(UserProfile userProfile, Text post) {
        System.out.println("Post created by account: "+ userProfile.getName() +" of content "+ post.getTextContent());
    }

}
