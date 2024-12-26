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

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public User(int userId, int name) {
        this.userId = userId;
        this.name = name;
    }

    int name;

}
