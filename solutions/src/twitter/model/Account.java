package twitter.model;

import java.time.LocalDateTime;

public abstract class Account {
    private int id;
    private LocalDateTime timeCreated;
    protected abstract void unfollowAccount(Account account);
    protected abstract void followAccount(Account account);

    public Account(int id) {
        this.id = id;
    }
}
