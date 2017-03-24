package com.bignerdranch.android.formulaone2017;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;

/**
 * Created by Avinash.Ganga on 2017/03/23.
 */

public class TeamFragment extends Fragment {

    private Team mTeam;
    private TextView mTeamName;
    private ImageView mTeamLogo;

    private final static String TAG = "TeamFragment";
    private static final String ARG_TEAM_ID = "team_id";


    public static TeamFragment newInstance(int index){
        Bundle args = new Bundle();
        args.putSerializable(ARG_TEAM_ID, index);

        TeamFragment fragment = new TeamFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int index  = (int) getArguments().getSerializable(ARG_TEAM_ID);

        mTeam = F1Teams2017.get(getActivity()).getTeamList().get(index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_team,container,false);

        mTeamName = (TextView) v.findViewById(R.id.viewpager_team_name);
        mTeamName.setText(mTeam.getTeamName());

        mTeamLogo = (ImageView) v.findViewById(R.id.viewpager_team_logo);
        mTeamLogo.setImageResource(mTeam.getTeamLogo());


        return v;
    }
}
