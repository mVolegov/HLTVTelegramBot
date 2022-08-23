package com.voleg.model;

public class Team {

    private String teamName;
    private String players;
    private String points;
    private String changesInPoints;
    private String position;
    private String teamLink;

    public Team(String teamName,
                String players,
                String points,
                String changesInPoints,
                String position,
                String teamLink) {
        this.teamName = teamName;
        this.players = players;
        this.points = points;
        this.changesInPoints = changesInPoints;
        this.position = position;
        this.teamLink = teamLink;
    }

    @Override
    public String toString() {
        return "\uD83D\uDCAA " + position + "  " + teamName + "  " + points + " " + changesInPoints + "\n"
                + "players: " + players + "\n"
                + "team: " + teamLink + "\n";
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getChangesInPoints() {
        return changesInPoints;
    }

    public void setChangesInPoints(String changesInPoints) {
        this.changesInPoints = changesInPoints;
    }

    public String getTeamLink() {
        return teamLink;
    }

    public void setTeamLink(String teamLink) {
        this.teamLink = teamLink;
    }
}
