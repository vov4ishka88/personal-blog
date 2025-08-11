package com.personalblog.model;

import java.util.List;

public class PostPreview {
    private long id;
    private String title;
    private String imageUrl;
    private String preview;
    private int commentsCount;
    private int likes;
    private List<String> tags;

    public PostPreview(long id, String title, String imageUrl,
                       String preview, int commentsCount, int likes, List<String> tags) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.preview = preview;
        this.commentsCount = commentsCount;
        this.likes = likes;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPreview() {
        return preview;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public int getLikes() {
        return likes;
    }

    public List<String> getTags() {
        return tags;
    }
}
