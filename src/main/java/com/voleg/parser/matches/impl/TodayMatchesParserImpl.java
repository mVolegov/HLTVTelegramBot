package com.voleg.parser.matches.impl;

import com.voleg.html.HtmlPage;
import com.voleg.model.Match;
import com.voleg.parser.matches.TodayMatchParser;
import com.voleg.parser.matches.TodayMatchesParser;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TodayMatchesParserImpl implements TodayMatchesParser {

    private final HtmlPage todayMatchesPage;
    private final TodayMatchParser todayMatchParser;

    public TodayMatchesParserImpl(HtmlPage todayMatchesPage, TodayMatchParser todayMatchParser) {
        this.todayMatchesPage = todayMatchesPage;
        this.todayMatchParser = todayMatchParser;
    }

    @Override
    public String getMatchesHeader() throws IOException {
        return getMatchDayHeadlineDiv().text();
    }

    @Override
    public String getMatchesLink() {
        return todayMatchesPage.getResourceURL();
    }

    @Override
    public List<Match> getMatches() throws IOException {
        Elements matchesDiv = getUpcomingMatchDiv();

        List<Match> matchList = new ArrayList<>();

        for (Element matchDiv : matchesDiv) {
            ((TodayMatchParserImpl) todayMatchParser).setMatchDiv(matchDiv);

            long matchTimeUnix = todayMatchParser.getMatchTime();
            String matchLink = todayMatchParser.getMatchLink();
            String matchInfo = todayMatchParser.getMatchInfo();

            matchList.add(new Match(matchTimeUnix, matchLink, matchInfo));
        }

        return matchList;
    }

    private Element getMatchDayHeadlineDiv() throws IOException {
        return getTodayMatchesDiv().child(0);
    }

    private Elements getUpcomingMatchDiv() throws IOException {
        return getTodayMatchesDiv().getElementsByAttributeValue("class", "upcomingMatch");
    }

    private Element getTodayMatchesDiv() throws IOException {
        return todayMatchesPage.getPage().getElementsByClass("upcomingMatchesSection").get(0);
    }
}
