package com.voleg.parser.results.impl;

import com.voleg.html.HtmlPage;
import com.voleg.model.MatchResult;
import com.voleg.parser.results.TodayResultParser;
import com.voleg.parser.results.TodayResultsParser;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TodayResultsParserImpl implements TodayResultsParser {

    private final HtmlPage todayResultsPage;
    private final TodayResultParser parser;

    public TodayResultsParserImpl(HtmlPage todayResultsPage, TodayResultParser parser) {
        this.todayResultsPage = todayResultsPage;
        this.parser = parser;
    }

    public String getResultsURL() {
        return todayResultsPage.getResourceURL();
    }

    @Override
    public List<MatchResult> getResults() throws IOException {
        List<MatchResult> resultsList = new ArrayList<>();

        Elements resultsDivs = getTodayResultsDivs();

        resultsDivs.forEach(resultDiv -> {
            ((TodayResultParserImpl) parser).setResultDiv(resultDiv);

            String firstTeam = parser.getFirstTeam();
            String resultScore = parser.getResultScore();
            String secondTeam = parser.getSecondTeam();
            String event = parser.getEvent();
            String map = parser.getMap();
            String matchLink = parser.getMatchLink();

            resultsList.add(new MatchResult(firstTeam, secondTeam, resultScore, event, map, matchLink));
        });

        return resultsList;
    }

    private Elements getTodayResultsDivs() throws IOException {
        return todayResultsPage.getPage().getElementsByAttributeValue("class", "results-sublist").get(0)
                .getElementsByAttributeValue("class", "result-con");
    }
    
    private Element getTodayResultHeaderDiv() throws IOException {
        return todayResultsPage.getPage().getElementsByAttributeValue("class", "results-sublist").get(0)
                .child(0);
    }
}
