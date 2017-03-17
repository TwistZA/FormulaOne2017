package com.bignerdranch.android.formulaone2017;

import android.media.Image;

/**
 * Created by Avinash.Ganga on 16/03/17.
 */

public class Team {
    public String mTeamName;
    public String[] mDrivers;
    public String mEngine;
    public int mTeamLogo;

    public Team(String teamName, String[] drivers, String engine, int teamLogo) {
        mTeamName = teamName;
        mDrivers = drivers;
        mEngine = engine;
        mTeamLogo = teamLogo;
    }

    public String getTeamName() {
        return mTeamName;
    }

    public String[] getDrivers() {
        return mDrivers;
    }

    public String getEngine() {
        return mEngine;
    }

    public int getTeamLogo() {
        return mTeamLogo;
    }
}
