package com.voleg.parser.news;

import com.voleg.model.News;

import java.io.IOException;
import java.util.List;

public interface TodayNewsParser {

    String getNewsLink() throws IOException;
    List<News> getNews() throws IOException;
}
