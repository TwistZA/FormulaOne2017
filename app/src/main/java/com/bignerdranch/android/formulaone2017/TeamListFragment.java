package com.bignerdranch.android.formulaone2017;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import static android.R.attr.finishOnCloseSystemDialogs;
import static android.R.attr.onClick;
import static android.R.attr.startDelay;
import static android.app.Activity.RESULT_OK;

/**
 * Created by Avinash.Ganga on 16/03/17.
 */

public class TeamListFragment extends Fragment {
    private RecyclerView mTeamRecyclerView;
    private TeamAdaptor mAdaptor;
    private final static String TAG="TeamListFragment";
    private static final String EXTRA_TEAM =
            "com.bignerdranch.android.geoquiz2.answer_shown";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_list,container,false);
        mTeamRecyclerView = (RecyclerView) view.findViewById(R.id.team_recycler_view);
        mTeamRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));


        updateUI();
        return view;
    }

    public void updateUI(){
        F1Teams2017 teams2017 = F1Teams2017.get(getActivity());
        List<Team> teams = teams2017.getTeamList();

        mAdaptor=new TeamAdaptor(teams);
        mTeamRecyclerView.setAdapter(mAdaptor);
    }

    public static int getTeamIndex(Intent result){
        return (result.getIntExtra(EXTRA_TEAM,0));
    };



    /* TEAM-HOLDER */
    class TeamHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTeamNameTextView;
        private ImageView mImageView;
        private Team mTeam;
        private CheckBox mCheckBox;


        public TeamHolder(View itemView) {
            super(itemView);
            mTeamNameTextView = (TextView) itemView.findViewById(R.id.list_item_teamname_textview);
            mImageView = (ImageView) itemView.findViewById(R.id.f1logo);
            itemView.setOnClickListener(this);
        }

        public void bindTeam(Team team){
            mTeam =team;
            mTeamNameTextView.setText(mTeam.getTeamName());
            mImageView.setImageResource(mTeam.getTeamLogo());
        }


        @Override
        public void onClick(View v) {
            Log.d(TAG,"onClick - value = "+getAdapterPosition());
            mCheckBox = (CheckBox) v.findViewById(R.id.list_checkbox_team);
            mCheckBox.toggle();

            Intent data=new Intent();
            data.putExtra(EXTRA_TEAM,getAdapterPosition());
            getActivity().setResult(RESULT_OK, data);

            Intent intent = TeamPagerActivity.newIntent(getActivity(), getAdapterPosition());
            startActivity(intent);

            getActivity().finish();
        }


    }

    /* TEAM ADAPTER */
    private class TeamAdaptor extends RecyclerView.Adapter<TeamHolder>{
        private List<Team> mTeamList;

        public TeamAdaptor(List<Team> teamList) {
            mTeamList = teamList;
        }

        @Override
        public TeamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view=layoutInflater.inflate(R.layout.list_item_team,parent,false);
            return new TeamHolder(view);
        }

        @Override
        public void onBindViewHolder(TeamHolder holder, int position) {
            Team team = mTeamList.get(position);
            holder.bindTeam(team);
        }

        @Override
        public int getItemCount() {
            return mTeamList.size();
        }
    }












}
