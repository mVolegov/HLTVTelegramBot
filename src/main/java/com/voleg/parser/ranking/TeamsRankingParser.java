package com.voleg.parser.ranking;

import com.voleg.model.Team;

import java.io.IOException;
import java.util.List;

public interface TeamsRankingParser {

    String getRankingHeader() throws IOException;
    String getRankingLink() throws IOException;
    List<Team> getTeams() throws IOException;
}
