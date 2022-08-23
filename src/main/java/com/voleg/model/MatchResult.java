package com.voleg.model;

public class MatchResult {

    private String firstTeam;
    private String secondTeam;
    private String resultScore;
    private String event;
    private String map;
    private String matchLink;

    public MatchResult() {}

    public MatchResult(String firstTeam,
                       String secondTeam,
                       String resultScore,
                       String event,
                       String map,
                       String matchLink) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.resultScore = resultScore;
        this.event = event;
        this.map = map;
        this.matchLink = matchLink;
    }

    @Override
    public String toString() {
        return "\uD83C\uDFC1  " + firstTeam + "  " + resultScore + "   " + secondTeam + " | " + map + "\n"
                + event + "\n"
                + "View match results: " + matchLink + "\n";
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public String getResultScore() {
        return resultScore;
    }

    public void setResultScore(String resultScore) {
        this.resultScore = resultScore;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
