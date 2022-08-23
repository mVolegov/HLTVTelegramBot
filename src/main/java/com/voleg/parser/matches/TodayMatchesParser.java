package com.voleg.parser.matches;

import com.voleg.model.Match;

import java.io.IOException;
import java.util.List;

public interface TodayMatchesParser {

    String getMatchesHeader() throws IOException;
    String getMatchesLink() throws IOException;
    List<Match> getMatches() throws IOException;
}
