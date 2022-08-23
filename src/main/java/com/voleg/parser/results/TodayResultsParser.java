package com.voleg.parser.results;

import com.voleg.model.MatchResult;

import java.io.IOException;
import java.util.List;

public interface TodayResultsParser {

    String getResultsURL() throws IOException;
    List<MatchResult> getResults() throws IOException;
}
