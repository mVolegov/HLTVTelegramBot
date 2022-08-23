package com.voleg.bot;

import com.voleg.responsebuilder.ResponseBuilder;

public class BotResponseBuilder {

    ResponseBuilder todayNewsResponseBuilder;
    ResponseBuilder teamRankingResponseBuilder;
    ResponseBuilder matchesResponseBuilder;
    ResponseBuilder resultsResponseBuilder;

    public BotResponseBuilder(ResponseBuilder todayNewsResponseBuilder,
                              ResponseBuilder teamRankingResponseBuilder,
                              ResponseBuilder matchesResponseBuilder,
                              ResponseBuilder resultsResponseBuilder) {
        this.todayNewsResponseBuilder = todayNewsResponseBuilder;
        this.teamRankingResponseBuilder = teamRankingResponseBuilder;
        this.matchesResponseBuilder = matchesResponseBuilder;
        this.resultsResponseBuilder = resultsResponseBuilder;
    }

    public String makeResponse(String command) {
        if (command.equals(CommandEnum.GET_NEWS_FOR_TODAY.getButtonName())) {
            return todayNewsResponseBuilder.build();
        } else if (command.equals(CommandEnum.GET_TEAMS_RANKING.getButtonName())) {
            return teamRankingResponseBuilder.build();
        } else if (command.equals(CommandEnum.GET_MATCHES_FOR_TODAY.getButtonName())) {
            return matchesResponseBuilder.build();
        } else if (command.equals(CommandEnum.GET_RESULTS_FOR_TODAY.getButtonName())) {
            return resultsResponseBuilder.build();
        } else if (command.equals(CommandEnum.START.getButtonName())) {
            return BasicResponseMessageEnum.WELCOME.getMessage();
        } else {
            return BasicResponseMessageEnum.UNKNOWN_COMMAND.getMessage();
        }
    }
}
