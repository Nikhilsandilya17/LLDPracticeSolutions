package socialnetworkingservice.model;

import java.time.LocalDateTime;

public class Text extends Post{

    private String textContent;

    public Text(String id, String title, String createdTime, String textContent) {
        super(id, title, createdTime);
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

}
