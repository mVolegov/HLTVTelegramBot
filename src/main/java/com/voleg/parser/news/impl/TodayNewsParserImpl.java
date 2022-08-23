package com.voleg.parser.news.impl;

import com.voleg.html.HtmlPage;
import com.voleg.model.News;
import com.voleg.parser.news.TodayNewsParser;
import com.voleg.parser.news.TodayOneNewsParser;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TodayNewsParserImpl implements TodayNewsParser {

    private final HtmlPage newsPage;
    private final TodayOneNewsParser parser;

    public TodayNewsParserImpl(HtmlPage newsPage, TodayOneNewsParser parser) {
        this.newsPage = newsPage;
        this.parser = parser;
    }

    @Override
    public String getNewsLink() {
        return newsPage.getResourceURL();
    }

    @Override
    public List<News> getNews() throws IOException {
        List<News> news = new ArrayList<>();

        Elements newsLinks = getNewsLinks();

        newsLinks.forEach(newsLink -> {
            ((TodayOneNewsParserImpl) parser).setNewsLink(newsLink);

            String newsHeader = parser.getNewsHeader();
            String newsURL = parser.getNewsURL();
            String newsTimeSincePost = parser.getTimeSincePost();

            News onePost = new News(newsHeader, newsURL, newsTimeSincePost);
            news.add(onePost);
        });

        return news;
    }

    private Elements getNewsLinks() throws IOException {
        return newsPage.getPage()
                .getElementsByAttributeValue("class", "standard-box standard-list").get(0)
                .getElementsByAttributeValue("class", "newsline article");
    }
}
