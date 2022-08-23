package com.voleg.confing;

import com.voleg.bot.BotResponseBuilder;
import com.voleg.bot.HLTVBot;
import com.voleg.html.HtmlPage;
import com.voleg.parser.matches.TodayMatchParser;
import com.voleg.parser.matches.TodayMatchesParser;
import com.voleg.parser.matches.impl.TodayMatchParserImpl;
import com.voleg.parser.matches.impl.TodayMatchesParserImpl;
import com.voleg.parser.news.TodayNewsParser;
import com.voleg.parser.news.TodayOneNewsParser;
import com.voleg.parser.news.impl.TodayNewsParserImpl;
import com.voleg.parser.news.impl.TodayOneNewsParserImpl;
import com.voleg.parser.ranking.TeamRankingParser;
import com.voleg.parser.ranking.TeamsRankingParser;
import com.voleg.parser.ranking.impl.TeamRankingParserImpl;
import com.voleg.parser.ranking.impl.TeamsRankingParserImpl;
import com.voleg.parser.results.TodayResultParser;
import com.voleg.parser.results.TodayResultsParser;
import com.voleg.parser.results.impl.TodayResultParserImpl;
import com.voleg.parser.results.impl.TodayResultsParserImpl;
import com.voleg.responsebuilder.ResponseBuilder;
import com.voleg.responsebuilder.impl.*;

public class AppConfigurer {

    public static HLTVBot configure() {
        HtmlPage todayMatchesPage = new HtmlPage("https://www.hltv.org/matches?predefinedFilter=top_tier");
        HtmlPage rankingPage = new HtmlPage("https://www.hltv.org/ranking/teams");
        HtmlPage newsPage = new HtmlPage("https://www.hltv.org");
        HtmlPage resultsPage = new HtmlPage("https://www.hltv.org/results");

        TodayMatchParser todayMatchParser = new TodayMatchParserImpl();
        TeamRankingParser teamRankingParser = new TeamRankingParserImpl();
        TodayOneNewsParser todayOneNewsParser = new TodayOneNewsParserImpl();
        TodayResultParser todayResultParser = new TodayResultParserImpl();

        TodayMatchesParser matchesParser = new TodayMatchesParserImpl(todayMatchesPage, todayMatchParser);
        TeamsRankingParser rankingParser = new TeamsRankingParserImpl(rankingPage, teamRankingParser);
        TodayNewsParser newsParser = new TodayNewsParserImpl(newsPage, todayOneNewsParser);
        TodayResultsParser resultsParser = new TodayResultsParserImpl(resultsPage, todayResultParser);

        ResponseBuilder todayNewsResponseBuilder = new TodayNewsResponseBuilderImpl(newsParser);
        ResponseBuilder teamRankingResponseBuilder = new TeamsRankingResponseBuilderImpl(rankingParser);
        ResponseBuilder matchesResponseBuilder = new TodayMatchesResponseBuilderImpl(matchesParser);
        ResponseBuilder resultsResponseBuilder = new TodayResultsResponseBuilderImpl(resultsParser);

        BotResponseBuilder responseBuilder = new BotResponseBuilder(todayNewsResponseBuilder,
                teamRankingResponseBuilder,
                matchesResponseBuilder,
                resultsResponseBuilder);

        return new HLTVBot(responseBuilder);
    }
}
