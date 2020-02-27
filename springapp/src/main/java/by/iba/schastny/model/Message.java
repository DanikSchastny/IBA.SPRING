package by.iba.schastny.model;

public class Message {
    private String text;
    private String currentTime;

    public Message(String text, String currentTime) {
        this.text = text;
        this.currentTime = currentTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String message) {
        this.text = message;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
