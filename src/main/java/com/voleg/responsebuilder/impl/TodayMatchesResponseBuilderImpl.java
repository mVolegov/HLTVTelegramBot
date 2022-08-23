package com.voleg.responsebuilder.impl;

import com.voleg.responsebuilder.ResponseBuilder;
import com.voleg.message.TodayMatchesResponseMessage;
import com.voleg.parser.matches.TodayMatchesParser;

import java.io.IOException;
import java.util.Collections;

public class TodayMatchesResponseBuilderImpl extends ResponseBuilder {

    private final TodayMatchesParser parser;
    private TodayMatchesResponseMessage matches;

    public TodayMatchesResponseBuilderImpl(TodayMatchesParser parser) {
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
        matches = new TodayMatchesResponseMessage();
        matches.setMatchesHeader(parser.getMatchesHeader());
        matches.setMatchesLink(parser.getMatchesLink());
        matches.setMatches(parser.getMatches());

        return matches.toString();
    }

    private String makeBadMessage() {
        matches = new TodayMatchesResponseMessage();
        matches.setMatchesHeader("Возникла ошибка");
        matches.setMatchesLink("Попробуйте снова");
        matches.setMatches(Collections.emptyList());

        return matches.toString();
    }
}
