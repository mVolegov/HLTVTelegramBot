package com.voleg.message;

import com.voleg.model.MatchResult;

import java.util.List;

public class TodayResultsResponseMessage {

    private String resultsURL;
    private List<MatchResult> matchResults;

    public TodayResultsResponseMessage() {}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Results link: ").append(resultsURL).append("\n\n");

        matchResults.forEach(matchResult -> sb.append(matchResult.toString()).append("\n"));

        return sb.toString();
    }

    public String getResultsURL() {
        return resultsURL;
    }

    public void setResultsURL(String resultsURL) {
        this.resultsURL = resultsURL;
    }

    public List<MatchResult> getMatchResults() {
        return matchResults;
    }

    public void setMatchResults(List<MatchResult> matchResults) {
        this.matchResults = matchResults;
    }
}
