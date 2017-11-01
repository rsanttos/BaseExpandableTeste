package com.example.ramonsantos.baseexpandableteste;

import java.util.ArrayList;

/**
 * Created by ramonsantos on 31/10/17.
 */

public class GroupInfo {
    private String teamName;
    private ArrayList<ChildInfo> list = new ArrayList<ChildInfo>();

    public String getName() {
        return teamName;
    }

    public void setName(String teamName) {
        this.teamName = teamName;
    }

    public ArrayList<ChildInfo> getPlayerName() {
        return list;
    }

    public void setPlayerName(ArrayList<ChildInfo> playerName) {
        this.list = playerName;
    }
}
