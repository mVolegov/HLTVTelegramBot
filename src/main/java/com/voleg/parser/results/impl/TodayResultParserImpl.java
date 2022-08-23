package com.voleg.parser.results.impl;

import com.voleg.parser.results.TodayResultParser;
import org.jsoup.nodes.Element;

public class TodayResultParserImpl implements TodayResultParser {

    private Element resultDiv;

    @Override
    public String getFirstTeam() {
        return resultDiv.getElementsByAttributeValue("class", "team-cell").get(0).text();
    }

    @Override
    public String getResultScore() {
        String scoreFirstPart = resultDiv.getElementsByAttributeValue("class", "result-score").get(0).child(0).text();
        String scoreSecondPart = resultDiv.getElementsByAttributeValue("class", "result-score").get(0).child(1).text();

        return scoreFirstPart + " - " + scoreSecondPart;
    }

    @Override
    public String getSecondTeam() {
        return resultDiv.getElementsByAttributeValue("class", "team-cell").get(1).text();
    }

    @Override
    public String getEvent() {
        return resultDiv.getElementsByAttributeValue("class", "event").text();
    }

    @Override
    public String getMap() {
        return resultDiv.getElementsByAttributeValue("class", "star-cell").get(0).child(0).text();
    }

    @Override
    public String getMatchLink() {
        return "https://www.hltv.org" + resultDiv.child(0).attr("href");
    }

    public void setResultDiv(Element resultDiv) {
        this.resultDiv = resultDiv;
    }
}
