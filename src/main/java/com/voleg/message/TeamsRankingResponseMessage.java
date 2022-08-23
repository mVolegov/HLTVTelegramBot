package com.voleg.message;

import com.voleg.model.Team;

import java.util.List;

public class TeamsRankingResponseMessage {

    private String rankingHeader;
    private String rankingLink;
    private List<Team> teams;

    public TeamsRankingResponseMessage() {}

    public TeamsRankingResponseMessage(String rankingHeader, String rankingLink, List<Team> teams) {
        this.rankingHeader = rankingHeader;
        this.rankingLink = rankingLink;
        this.teams = teams;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(rankingHeader).append("\n");
        sb.append("Rating link: ").append(rankingLink).append("\n\n");

        teams.forEach(team -> sb.append(team.toString()).append("\n"));

        return sb.toString();
    }

    public String getRankingHeader() {
        return rankingHeader;
    }

    public void setRankingHeader(String rankingHeader) {
        this.rankingHeader = rankingHeader;
    }

    public String getRankingLink() {
        return rankingLink;
    }

    public void setRankingLink(String rankingLink) {
        this.rankingLink = rankingLink;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
