package com.bignerdranch.android.formulaone2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/**
 * Created by Avinash.Ganga on 17/03/17.
 */

public class SelectionFragment extends Fragment {
    private Button mButtonTeam, mButtonDriver;
    private TextView mTextViewTeam;
    private static final int REQUEST_TEAM=1;
    public static final String TAG = "Selection Fragment";
    private F1Teams2017 mTeams2017;
    List<Team> teamList;
    private ImageView mUserTeamLogo;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selection_page,container,false);

        mButtonTeam = (Button) view.findViewById(R.id.button_choose_team);
        mButtonTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = TeamListActivity.newIntent(getActivity());


                startActivityForResult(intent, REQUEST_TEAM);
            }
        });


        mButtonDriver = (Button) view.findViewById(R.id.button_choose_driver);

        mTextViewTeam = (TextView) view.findViewById(R.id.user_team);

        mTeams2017 = F1Teams2017.get(getActivity());
        teamList = mTeams2017.getTeamList();

        mUserTeamLogo = (ImageView) view.findViewById(R.id.user_team_logo);



        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_TEAM){
            if (resultCode==RESULT_OK){
                int i = TeamListFragment.getTeamIndex(data);

                mTextViewTeam.setText(teamList.get(i).getTeamName());
                mUserTeamLogo.setImageResource(teamList.get(i).getTeamLogo());
                Log.d(TAG,"data is "+i);

            }
            else if (resultCode==RESULT_CANCELED){

            }
        }
    }
}
