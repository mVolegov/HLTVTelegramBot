package com.voleg.bot;

public enum BasicResponseMessageEnum {

    WELCOME("Hello"),
    UNKNOWN_COMMAND("Unknown command"),
    UNKNOWN_MESSAGE("Sorry, I don't understand you");

    private final String response;

    BasicResponseMessageEnum(String response) {
        this.response = response;
    }

    String getMessage() {
        return response;
    }
}
