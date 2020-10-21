package com.stackroute.oops.league.model;

/**
 * This class contains five fields playerId,playerName,password,yearExpr and teamTitle
 * It is a subclass of Comparable interface
 */
public class Player extends Thread implements Comparable {
    //Parameterized Constructor to initialize all properties
    public Player(String playerId, String playerName, String password, int yearExpr) {
    }

    public String getPlayerId() {
        return null;
    }

    public String getPlayerName() {
        return null;
    }

    public String getPassword() {
        return null;
    }

    public int getYearExpr() {
        return 0;
    }

    //Return teamTitle if it is present and not empty
    public String getTeamTitle() {
        return null;
    }

    public void setTeamTitle(String teamTitle) {
    }

    /**
     * This overridden method should return player details in below format
     * Player{playerId=xxxxx, playerName=xxxxxx, yearExpr=xxxxxx,teamTitle=xxxxxxxx}-> if league team title is set
     * Player{playerId=xxxxx, playerName=xxxxxx, yearExpr=xxxxxx}-> if league team title not set
     */
    @Override
    public String toString() {
        return null;
    }

    //Overridden equals method
    @Override
    public boolean equals(Object object) {
        return false;
    }

    //Overridden hashcode method
    @Override
    public int hashCode() {
        return 0;
    }

    //compares player object based on playerId
    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
