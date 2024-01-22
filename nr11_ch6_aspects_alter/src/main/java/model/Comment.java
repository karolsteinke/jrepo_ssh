package model;

public class Comment {
    
    private String author;
    private String text;

    //getters and setters
    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getText() {
        return this.text;
    }

    public String getAuthor() {
        return this.author;
    }
}
