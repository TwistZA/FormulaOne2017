package com.bignerdranch.android.formulaone2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Avinash.Ganga on 2017/03/17.
 */

public class DriverListFragment extends Fragment {

    private RecyclerView mDriverRecyclerView;
    private DriverListFragment.DriverAdaptor mAdaptor;
    private final static String TAG="DriverListFragment";
    private static final String EXTRA_DRIVER =
            "com.bignerdranch.android.f12017_driver";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_driver_list,container,false);
        mDriverRecyclerView = (RecyclerView) view.findViewById(R.id.driver_recycler_view);
        mDriverRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));


        updateUI();
        return view;
    }

    public void updateUI(){
        F1Teams2017 teams2017 = F1Teams2017.get(getActivity());
        List<Team> teams = teams2017.getTeamList();

        mAdaptor=new DriverListFragment.DriverAdaptor(teams);
        mDriverRecyclerView.setAdapter(mAdaptor);
    }

    public static int getTeamIndex(Intent result){
        return (result.getIntExtra(EXTRA_DRIVER,0));
    };



    /* DRIVER-HOLDER */
    class DriverHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTeamNameTextView,mTextViewDriver1,mTextViewDriver2;
        private Team mTeam;
        private CheckBox mCheckBox1,mCheckBox2;


        public DriverHolder(View itemView) {
            super(itemView);
            mTeamNameTextView = (TextView) itemView.findViewById(R.id.list_item_teamname_textview);
            mTextViewDriver1 = (TextView) itemView.findViewById(R.id.list_item_driver1);
            mTextViewDriver2 = (TextView) itemView.findViewById(R.id.list_item_driver2);

            itemView.setOnClickListener(this);
        }

        public void bindTeam(Team team){
            mTeam =team;
            mTeamNameTextView.setText(mTeam.getTeamName());
            mTextViewDriver1.setText("HELLO");
            mTextViewDriver2.setText("WORLD");
        }


        @Override
        public void onClick(View v) {
            Log.d(TAG,"onClick - value = "+getAdapterPosition());
            mCheckBox1 = (CheckBox) v.findViewById(R.id.list_checkbox_driver1);
            mCheckBox1.toggle();

            mCheckBox2 = (CheckBox) v.findViewById(R.id.list_checkbox_driver2);
            mCheckBox2.toggle();



            Intent data=new Intent();
            data.putExtra(EXTRA_DRIVER,getAdapterPosition());
            getActivity().setResult(RESULT_OK, data);

            getActivity().finish();
        }


    }

    /* TEAM ADAPTER */
    private class DriverAdaptor extends RecyclerView.Adapter<DriverListFragment.DriverHolder>{
        private List<Team> mTeamList;

        public DriverAdaptor(List<Team> teamList) {
            mTeamList = teamList;
        }

        @Override
        public DriverListFragment.DriverHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view=layoutInflater.inflate(R.layout.list_item_driver,parent,false);
            return new DriverListFragment.DriverHolder(view);
        }

        @Override
        public void onBindViewHolder(DriverListFragment.DriverHolder holder, int position) {
            Team team = mTeamList.get(position);
            holder.bindTeam(team);
        }

        @Override
        public int getItemCount() {
            return mTeamList.size();
        }
    }




}
