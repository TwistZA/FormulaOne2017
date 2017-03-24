package com.bignerdranch.android.formulaone2017;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

/**
 * Created by Avinash.Ganga on 2017/03/23.
 */

public class TeamPagerActivity extends FragmentActivity {
    private static final String EXTRA_TEAM_ID =
            "com.bignerdranch.android.f12017.team_id";

    private ViewPager mViewPager;
    private List<Team> mTeams;

    public static Intent newIntent(Context packageContext, int index) {
        Intent intent = new Intent(packageContext, TeamPagerActivity.class);
        intent.putExtra(EXTRA_TEAM_ID, index);
        return intent;
    }


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_pager);

        int team_index = (int) getIntent().getSerializableExtra(EXTRA_TEAM_ID);


        mViewPager = (ViewPager) findViewById(R.id.activity_team_pager_view_pager);
        mTeams = F1Teams2017.get(this).getTeamList();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return TeamFragment.newInstance(position);
            }
            @Override
            public int getCount() {
                return mTeams.size();
            }
        });

        mViewPager.setCurrentItem(team_index);


    }
}
