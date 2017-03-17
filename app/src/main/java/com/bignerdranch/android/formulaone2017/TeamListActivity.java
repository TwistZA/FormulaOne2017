package com.bignerdranch.android.formulaone2017;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class TeamListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new TeamListFragment();
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, TeamListActivity.class);
        return intent;
    }




}
