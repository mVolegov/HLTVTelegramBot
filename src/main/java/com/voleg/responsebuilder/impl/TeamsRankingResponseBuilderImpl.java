package com.voleg.responsebuilder.impl;

import com.voleg.responsebuilder.ResponseBuilder;
import com.voleg.message.TeamsRankingResponseMessage;
import com.voleg.parser.ranking.TeamsRankingParser;

import java.io.IOException;
import java.util.Collections;

public class TeamsRankingResponseBuilderImpl extends ResponseBuilder {

    private final TeamsRankingParser parser;
    private TeamsRankingResponseMessage ranking;

    public TeamsRankingResponseBuilderImpl(TeamsRankingParser parser) {
        this.parser = parser;
    }

    @Override
    public String build() {
        try {
            return makeMessage();
        } catch (IOException e) {
            return makeBadMessage();
        }
    }

    private String makeMessage() throws IOException {
        ranking = new TeamsRankingResponseMessage();
        ranking.setRankingHeader(parser.getRankingHeader());
        ranking.setRankingLink(parser.getRankingLink());
        ranking.setTeams(parser.getTeams());

        return ranking.toString();
    }

    private String makeBadMessage() {
        ranking = new TeamsRankingResponseMessage();
        ranking.setRankingHeader("Возникла ошибка");
        ranking.setRankingLink("Попробуйте снова");
        ranking.setTeams(Collections.emptyList());

        return ranking.toString();
    }
}
