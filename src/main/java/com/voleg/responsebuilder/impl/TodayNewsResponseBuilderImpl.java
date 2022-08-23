package com.voleg.responsebuilder.impl;

import com.voleg.responsebuilder.ResponseBuilder;
import com.voleg.message.TodayNewsResponseMessage;
import com.voleg.parser.news.TodayNewsParser;

import java.io.IOException;
import java.util.Collections;

public class TodayNewsResponseBuilderImpl extends ResponseBuilder {

    private final TodayNewsParser parser;
    private TodayNewsResponseMessage news;

    public TodayNewsResponseBuilderImpl(TodayNewsParser parser) {
        this.parser = parser;
    }

    @Override
    public String build() {
        try {
            return makeMessage();
        } catch (IOException e) {
            return makeBadMessage();
        }
    }

    private String makeMessage() throws IOException {
        news = new TodayNewsResponseMessage();
        news.setNewsLink(parser.getNewsLink());
        news.setNews(parser.getNews());

        return news.toString();
    }

    private String makeBadMessage() {
        news = new TodayNewsResponseMessage();
        news.setNewsLink("Возникла ошибка, попробуйте снова");
        news.setNews(Collections.emptyList());

        return news.toString();
    }
}
