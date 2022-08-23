package com.voleg.parser.ranking.impl;

import com.voleg.parser.ranking.TeamRankingParser;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TeamRankingParserImpl implements TeamRankingParser {

    private Element teamDiv;
    private Element rankingHeaderDiv;
    private Element lineUpCon;

    @Override
    public String getTeamName() {
        return rankingHeaderDiv.child(2).child(0).child(0).text();
    }

    @Override
    public String getTeamPosition() {
        return rankingHeaderDiv.child(0).text();
    }

    @Override
    public String getTeamPoints() {
        return rankingHeaderDiv.child(2).child(0).child(1).text();
    }

    @Override
    public String getTeamPlayers() {
        Element teamPlayers = rankingHeaderDiv.child(2).child(1);

        Elements teamPlayersDivs = teamPlayers.getElementsByAttributeValue("class", "rankingNicknames");

        StringBuilder sb = new StringBuilder("| ");

        teamPlayersDivs.forEach(teamPlayerDiv -> {
            String playerNickname = teamPlayerDiv.child(0).text();
            sb.append(playerNickname).append(" | ");
        });

        return sb.toString();
    }

    @Override
    public String getChangesInPoints() {
        return rankingHeaderDiv.child(4).text();
    }

    @Override
    public String getTeamLink() {
        return "https://www.hltv.org" + lineUpCon.attr("href");
    }

    public void setTeamDiv(Element teamDiv) {
        this.teamDiv = teamDiv;

        setRankingHeaderDiv();
        setLineUpCon();
    }

    private void setRankingHeaderDiv() {
        rankingHeaderDiv = teamDiv.child(0).child(0);
    }

    private void setLineUpCon() {
        lineUpCon = teamDiv.child(0).child(1).child(1).child(0);
    }
}
