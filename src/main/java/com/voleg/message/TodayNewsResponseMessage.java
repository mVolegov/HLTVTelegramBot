package com.voleg.message;

import com.voleg.model.News;

import java.util.List;

public class TodayNewsResponseMessage {

    private String newsLink;
    private List<News> newsList;

    public TodayNewsResponseMessage() {}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("News link: ").append(newsLink).append("\n\n");

        newsList.forEach(news -> sb.append(news.toString()).append("\n"));

        return sb.toString();
    }

    public String getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink;
    }

    public void setNews(List<News> newsList) {
        this.newsList = newsList;
    }
}
