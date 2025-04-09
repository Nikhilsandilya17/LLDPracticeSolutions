package socialnetworkingservice.service;

import socialnetworkingservice.model.Account;
import socialnetworkingservice.model.Post;
import socialnetworkingservice.model.Text;
import socialnetworkingservice.model.UserProfile;

public interface UserService {
    void createPost(UserProfile userProfile, Text post);
}



