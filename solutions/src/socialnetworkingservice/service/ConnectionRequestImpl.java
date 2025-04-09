package socialnetworkingservice.service;

import socialnetworkingservice.model.UserProfile;

import java.util.List;
import java.util.Map;

public class ConnectionRequestImpl implements ConnectionRequest{

    @Override
    public void sendConnectionRequest(UserProfile fromUser, UserProfile toUser) {
        System.out.println("Connection request sent from: " +fromUser.getName() + " to: "+ toUser.getName());

    }

    @Override
    public void acceptConnectionRequest(List<UserProfile> pendingRequest) {

        System.out.println("Connection Request accepted");
    }

    @Override
    public void declineConnectionRequest(List<UserProfile> pendingRequest) {
        System.out.println("Connection Request Declined");

    }

}
