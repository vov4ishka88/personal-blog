package com.personalblog.model;

public class Comment {
    private long id;
    private long postId;
    private String text;

    public Comment(long id, long postId, String text) {
        this.id=id; this.postId=postId; this.text=text;
    }

    public long getId() { return id; }
    public long getPostId() { return postId; }
    public String getText() { return text; }
}
