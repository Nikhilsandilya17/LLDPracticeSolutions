package socialnetworkingservice.service;

import socialnetworkingservice.model.UserProfile;

public interface UserFriendsService {
    void viewFriendsList(UserProfile userProfile);
    void removeFriends(UserProfile userProfile);
}
