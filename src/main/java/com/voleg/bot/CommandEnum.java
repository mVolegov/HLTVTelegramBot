package com.voleg.bot;

public enum CommandEnum {

    START("/start"),

    GET_NEWS_FOR_TODAY("/news"),
    GET_TEAMS_RANKING("/team_ranking"),
    GET_MATCHES_FOR_TODAY("/matches"),
    GET_RESULTS_FOR_TODAY("/results");

    private final String buttonName;

    CommandEnum(String buttonName) {
        this.buttonName = buttonName;
    }

    String getButtonName() {
        return buttonName;
    }
}
