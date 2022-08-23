package com.voleg.parser.matches.impl;

import com.voleg.parser.matches.TodayMatchParser;
import org.jsoup.nodes.Element;

public class TodayMatchParserImpl implements TodayMatchParser {

    private Element matchDiv;

    @Override
    public long getMatchTime() {
        return Long.parseLong(matchDiv.child(0).child(0).child(0).attr("data-unix"));
    }

    @Override
    public String getMatchLink() {
        return "https://www.hltv.org/" +  matchDiv.child(0).attr("href");
    }

    @Override
    public String getMatchInfo() {
        String firstTeam = "";
        String secondTeam = "";

        try {
            firstTeam = getFirstTeam(matchDiv);
            secondTeam = getSecondTeam(matchDiv);

            return firstTeam + " vs " + secondTeam;
        } catch (IndexOutOfBoundsException e) {
            if (!firstTeam.isEmpty()) {
                secondTeam = getUnknownSecondTeam(matchDiv);

                return firstTeam + " vs " + secondTeam;
            }

            return getGeneralInformation(matchDiv);
        }
    }

    private String getFirstTeam(Element matchDiv) {
        return matchDiv.child(0).child(1).child(0).child(1).text();
    }

    private String getSecondTeam(Element matchDiv) {
        return matchDiv.child(0).child(1).child(1).child(1).text();
    }

    private String getUnknownSecondTeam(Element matchDiv) {
        return matchDiv.child(0).child(1).child(1).child(0).text();
    }

    private String getGeneralInformation(Element matchDiv) {
        return matchDiv.child(0).child(1).child(0).text();
    }

    public void setMatchDiv(Element matchDiv) {
        this.matchDiv = matchDiv;
    }
}
