package com.voleg.parser.news.impl;

import com.voleg.parser.news.TodayOneNewsParser;
import org.jsoup.nodes.Element;

public class TodayOneNewsParserImpl implements TodayOneNewsParser {

    private Element newsLink;

    @Override
    public String getNewsHeader() {
        return newsLink.child(1).text();
    }

    @Override
    public String getNewsURL() {
        String url = newsLink.attr("href");

        return "https://www.hltv.org" + url + "\n";
    }

    @Override
    public String getTimeSincePost() {
        return newsLink.child(2).child(0).text();
    }

    public void setNewsLink(Element newsLink) {
        this.newsLink = newsLink;
    }
}
