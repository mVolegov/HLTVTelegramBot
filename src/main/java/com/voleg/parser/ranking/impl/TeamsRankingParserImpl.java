package com.voleg.parser.ranking.impl;

import com.voleg.html.HtmlPage;
import com.voleg.model.Team;
import com.voleg.parser.ranking.TeamRankingParser;
import com.voleg.parser.ranking.TeamsRankingParser;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamsRankingParserImpl implements TeamsRankingParser {

    private final HtmlPage teamsRankingPage;
    private final TeamRankingParser parser;

    public TeamsRankingParserImpl(HtmlPage teamsRankingPage, TeamRankingParser parser) {
        this.teamsRankingPage = teamsRankingPage;
        this.parser = parser;
    }

    @Override
    public String getRankingHeader() throws IOException {
        return getRegionalRankingHeaderDiv().text();
    }

    @Override
    public String getRankingLink() {
        return teamsRankingPage.getResourceURL();
    }

    @Override
    public List<Team> getTeams() throws IOException {
        Elements teamsDivs = getRankedTeamStandardBoxDiv();

        List<Team> teamList = new ArrayList<>();

        teamsDivs.forEach(teamDiv -> {
            ((TeamRankingParserImpl) parser).setTeamDiv(teamDiv);

            String teamPosition = parser.getTeamPosition();
            String teamName = parser.getTeamName();
            String teamPoints = parser.getTeamPoints();
            String teamPlayers = parser.getTeamPlayers();
            String changesInPoints = parser.getChangesInPoints();
            String teamLink = parser.getTeamLink();

            teamList.add(new Team(teamName, teamPlayers, teamPoints, changesInPoints, teamPosition, teamLink));
        });

        return teamList;
    }

    private Element getRegionalRankingHeaderDiv() throws IOException {
        return getRankingDiv().child(2);
    }

    private Elements getRankedTeamStandardBoxDiv() throws IOException {
        return getRankingDiv().getElementsByAttributeValue("class", "ranked-team standard-box");
    }

    private Element getRankingDiv() throws IOException {
        return teamsRankingPage.getPage().getElementsByAttributeValue("class", "ranking").get(0).child(0);
    }
}
