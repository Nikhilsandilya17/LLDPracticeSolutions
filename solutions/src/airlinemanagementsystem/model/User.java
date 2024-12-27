package airlinemanagementsystem.model;

import java.util.List;

public class User {
    int userId;

    List<Booking> bookings;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    String name;

}
