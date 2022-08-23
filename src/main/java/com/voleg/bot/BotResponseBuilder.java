package com.voleg.bot;

import com.voleg.responsebuilder.ResponseBuilder;

public class BotResponseBuilder {

    private static final String WELCOME = "Hello";
    private static final String UNKNOWN_COMMAND = "Unknown command";

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
        if (command.equals("/news")) {
            return todayNewsResponseBuilder.build();
        } else if (command.equals("/team_ranking")) {
            return teamRankingResponseBuilder.build();
        } else if (command.equals("/matches")) {
            return matchesResponseBuilder.build();
        } else if (command.equals("/results")) {
            return resultsResponseBuilder.build();
        } else if (command.equals("/start")) {
            return WELCOME;                                // ?
        } else {
            return UNKNOWN_COMMAND;
//            return unknownCommandResponseBuilder.build();   // ?
            // return "Unknown command";                    // ?
        }
    }
}
