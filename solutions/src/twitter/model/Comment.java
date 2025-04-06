package twitter.model;

import twitter.service.Commentable;

import java.time.LocalDateTime;

public class Comment implements Commentable{
    private int id;
    private IsLiked isLiked;
    private String content;
    private LocalDateTime commentCreated;
    private Commentable parentComment;


    @Override
    public boolean doComment() {
        return false;
    }
}
