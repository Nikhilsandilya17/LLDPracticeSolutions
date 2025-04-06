package twitter.service;

import twitter.model.Posts;
import twitter.model.User;

public interface PostService {
    void createPost(Posts post, User user);

}
