package twitter.model;

import twitter.service.Commentable;

public class Posts implements Commentable {

    @Override
    public boolean doComment() {
        return false;
    }
}
