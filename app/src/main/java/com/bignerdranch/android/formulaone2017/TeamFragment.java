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

import java.util.UUID;

/**
 * Created by Avinash.Ganga on 2017/03/23.
 */

public class TeamFragment extends Fragment {

    private Team mTeam;
    private EditText mTitle_Field;
    private CheckBox mSolvedCheckBox;
    private Button mDateButton;
    private final static String TAG = "TeamFragment";
    private static final String ARG_TEAM_ID = "team_id";


    public static TeamFragment newInstance(UUID crimeId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_TEAM_ID, crimeId);

        TeamFragment fragment = new TeamFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mTeam = new Team();

        UUID crimeId = (UUID) getArguments().getSerializable(ARG_TEAM_ID);
        mTeam = F1Teams2017.get(getActivity()).getTeamList(crimeId);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_crime,container,false);

        mTitle_Field = (EditText) v.findViewById(R.id.crime_title);
        mTitle_Field.setText(mCrime.getTitle());
        mTitle_Field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = (Button) v.findViewById(R.id.crime_date);
        String sDate = (String) DateFormat.format("EEEE, d MMMM yyyy",mCrime.getDate());
        mDateButton.setText(sDate);
        mDateButton.setEnabled(false);



        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        return v;
    }
}
