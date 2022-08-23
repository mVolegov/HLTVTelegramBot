package com.voleg.model;

public class News {

    private String newsHeader;
    private String newsLink;
    private String timeSincePost;

    public News() {}

    public News(String newsHeader, String newsLink, String timeSincePost) {
        this.newsHeader = newsHeader;
        this.newsLink = newsLink;
        this.timeSincePost = timeSincePost;
    }

    @Override
    public String toString() {
        return timeSincePost + "\n" + "\uD83D\uDCE2"+ "  " + newsHeader + "\n" + newsLink;
    }

    public String getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink;
    }

    public String getNewsHeader() {
        return newsHeader;
    }

    public void setNewsHeader(String newsHeader) {
        this.newsHeader = newsHeader;
    }

    public String getTimeSincePost() {
        return timeSincePost;
    }

    public void setTimeSincePost(String timeSincePost) {
        this.timeSincePost = timeSincePost;
    }
}
