package socialnetworkingservice.model;

import java.time.LocalDateTime;

public class Images extends Post{
    private String imageBody;

    public Images(String id, String title, String createdTime, String imageBody) {
        super(id, title, createdTime);
        this.imageBody = imageBody;
    }

    public String getImageBody() {
        return imageBody;
    }

    public void setImageBody(String imageBody) {
        this.imageBody = imageBody;
    }
}
