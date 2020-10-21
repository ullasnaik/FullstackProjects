package com.stackroute.oops.league.model;

import java.io.Serializable;

/**
 * This class contains four fields playerId,teamTitle,season and experience.
 * This is a subclass of Serializable and Comparable interface
 */
public class PlayerTeam implements Serializable, Comparable {

    //Parameterized Constructor to initialize all properties
    public PlayerTeam(String playerId, String teamTitle) {
    }

    public String getPlayerId() {
        return null;
    }

    public String getTeamTitle() {
        return null;
    }

    /**
     * This overridden method should return player details in below format
     * Player{playerId=xxxxx, teamTitle=xxxxxx}
     */
    @Override
    public String toString() {
        return null;
    }

    //Overridden compare method based on playerId
    @Override
    public int compareTo(Object object) {
        return 0;
    }
}
