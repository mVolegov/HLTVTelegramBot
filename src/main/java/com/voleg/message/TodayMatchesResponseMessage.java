package com.voleg.message;

import com.voleg.model.Match;

import java.util.List;

public class TodayMatchesResponseMessage {

    private String matchesHeader;
    private String matchesLink;
    private List<Match> matches;

    public TodayMatchesResponseMessage() {}

    public TodayMatchesResponseMessage(String matchesHeader, String matchesLink, List<Match> matches) {
        this.matchesHeader = matchesHeader;
        this.matchesLink = matchesLink;
        this.matches = matches;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(matchesHeader).append("\n");
        sb.append("Matches link : ").append(matchesLink).append("\n\n");

        matches.forEach(match -> sb.append(match.toString()).append("\n"));

        return sb.toString();
    }

    public String getMatchesHeader() {
        return matchesHeader;
    }

    public void setMatchesHeader(String matchesHeader) {
        this.matchesHeader = matchesHeader;
    }

    public String getMatchesLink() {
        return matchesLink;
    }

    public void setMatchesLink(String matchesLink) {
        this.matchesLink = matchesLink;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
