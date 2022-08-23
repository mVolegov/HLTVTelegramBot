package com.voleg.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Match {

    private String matchTime;
    private String matchLink;
    private String matchInfo;

    public Match() {}

    public Match(long matchTime, String matchLink, String matchInfo) {
        this.matchTime = convertUnixTimestampToDate(matchTime);
        this.matchLink = matchLink;
        this.matchInfo = matchInfo;
    }

    private String convertUnixTimestampToDate(long timestamp) {
        return new SimpleDateFormat("HH:mm").format(new Date(timestamp));
    }

    @Override
    public String toString() {
        return matchTime + "\n"
                + "\uD83D\uDD2B " + matchInfo + "\n"
                + matchLink + "\n";
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getMatchInfo() {
        return matchInfo;
    }

    public void setMatchInfo(String matchInfo) {
        this.matchInfo = matchInfo;
    }
}
