package socialnetworkingservice.service;

import socialnetworkingservice.model.UserProfile;

import java.util.List;

public interface ConnectionRequest {
    void sendConnectionRequest(UserProfile fromUser, UserProfile toUser);
    void acceptConnectionRequest(List<UserProfile> pendingRequest) ;
    void declineConnectionRequest(List<UserProfile> pendingRequest);
}
