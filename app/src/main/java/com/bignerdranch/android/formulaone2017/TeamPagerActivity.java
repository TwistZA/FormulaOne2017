package com.bignerdranch.android.formulaone2017;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by Avinash.Ganga on 2017/03/23.
 */

public class TeamPagerActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private List<Team> mTeams;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_pager);

        mViewPager = (ViewPager) findViewById(R.id.activity_team_pager_view_pager);
        mTeams = F1Teams2017.get(this).getTeamList();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Team team = mTeams.get(position);
                return TeamFragment.newInstance(mTeams.);
            }
            @Override
            public int getCount() {
                return mTeams.size();
            }
        });
    }
}
