package socialnetworkingservice.model;

import java.time.LocalDateTime;

public abstract class Post {
    private String id;
    private String title;
    private String createdTime;

    public Post(String id, String title, String createdTime) {
        this.id = id;
        this.title = title;
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
