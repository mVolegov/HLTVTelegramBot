package com.voleg.responsebuilder.impl;

import com.voleg.responsebuilder.ResponseBuilder;
import com.voleg.message.TodayResultsResponseMessage;
import com.voleg.parser.results.TodayResultsParser;

import java.io.IOException;
import java.util.Collections;

public class TodayResultsResponseBuilderImpl extends ResponseBuilder {

    private final TodayResultsParser parser;
    private TodayResultsResponseMessage results;

    public TodayResultsResponseBuilderImpl(TodayResultsParser parser) {
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


        results = new TodayResultsResponseMessage();
        results.setResultsURL(parser.getResultsURL());
        results.setMatchResults(parser.getResults());

        return results.toString();
    }

    private String makeBadMessage() {
        results = new TodayResultsResponseMessage();
        results.setMatchResults(Collections.emptyList());

        return results.toString();
    }
}
