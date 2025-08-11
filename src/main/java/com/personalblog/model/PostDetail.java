package com.personalblog.model;

import java.util.List;

public class PostDetail {
    private long id;
    private String title;
    private String imageUrl;
    private List<String> paragraphs;
    private List<String> tags;
    private int likes;

    public PostDetail(long id, String title, String imageUrl,
                      List<String> paragraphs, List<String> tags, int likes) {

        this.id = id; this.title = title; this.imageUrl = imageUrl;
        this.paragraphs = paragraphs; this.tags = tags; this.likes = likes;
    }
    public long getId() { return id; }
    public String getTitle() { return title; }
    public String getImageUrl() { return imageUrl; }
    public List<String> getParagraphs() { return paragraphs; }
    public List<String> getTags() { return tags; }
    public int getLikes() { return likes; }
}
