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
    private static final String EXTRA_DRIVER1 =
            "com.bignerdranch.android.f12017_driver1";
    private static final String EXTRA_DRIVER2 =
            "com.bignerdranch.android.f12017_driver2";
    private static int mUserDriverCount=0;
    private static String mDriversExtras[]={null,null};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_driver_list,container,false);
        mDriverRecyclerView = (RecyclerView) view.findViewById(R.id.driver_recycler_view);
        mDriverRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mUserDriverCount=0;

        updateUI();
        return view;
    }

    public void updateUI(){
        F1Teams2017 teams2017 = F1Teams2017.get(getActivity());
        List<Team> teams = teams2017.getTeamList();

        mAdaptor=new DriverListFragment.DriverAdaptor(teams);
        mDriverRecyclerView.setAdapter(mAdaptor);
    }

    public static String getDriver1(Intent result){
        Log.d(TAG,"getDriver1 returns "+result.getStringExtra(EXTRA_DRIVER1));
        return (result.getStringExtra(EXTRA_DRIVER1));
    };

    public static String getDriver2(Intent result){
        Log.d(TAG,"getDriver2 returns "+result.getStringExtra(EXTRA_DRIVER2));
        return (result.getStringExtra(EXTRA_DRIVER2));
    };



    /* DRIVER-HOLDER */
    class DriverHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTeamNameTextView,mTextViewDriver1,mTextViewDriver2;
        private Team mTeam;
        private CheckBox mCheckBox1,mCheckBox2;



        public DriverHolder(View itemView) {
            super(itemView);
            mCheckBox1 = (CheckBox) itemView.findViewById(R.id.list_checkbox_driver1);
            mTeamNameTextView = (TextView) itemView.findViewById(R.id.list_item_teamname_textview);
            mTextViewDriver1 = (TextView) itemView.findViewById(R.id.list_item_driver1);
            mTextViewDriver1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG,"mTextViewDriver1 clicked at position : "+getAdapterPosition()+" "+mTeam.getDrivers()[0]);

                    mCheckBox1.toggle();

                    mDriversExtras[mUserDriverCount] = mTeam.getDrivers()[0];

                    Intent data=new Intent();

                    mUserDriverCount++;
                    if (mUserDriverCount>=2) {
                        data.putExtra(EXTRA_DRIVER1,mDriversExtras[0]);
                        data.putExtra(EXTRA_DRIVER2,mDriversExtras[1]);
                        getActivity().setResult(RESULT_OK, data);
                        getActivity().finish();
                    }

                }
            });


            mCheckBox2 = (CheckBox) itemView.findViewById(R.id.list_checkbox_driver2);
            mTextViewDriver2 = (TextView) itemView.findViewById(R.id.list_item_driver2);
            mTextViewDriver2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG,"mTextViewDriver2 clicked at position : "+getAdapterPosition()+" "+mTeam.getDrivers()[1]);

                    mCheckBox2.toggle();

                    mDriversExtras[mUserDriverCount] = mTeam.getDrivers()[1];

                    Intent data=new Intent();

                    mUserDriverCount++;
                    if (mUserDriverCount>=2) {
                        data.putExtra(EXTRA_DRIVER1,mDriversExtras[0]);
                        data.putExtra(EXTRA_DRIVER2,mDriversExtras[1]);
                        getActivity().setResult(RESULT_OK, data);
                        getActivity().finish();
                    }

                }
            });




            itemView.setOnClickListener(this);
        }

        public void bindTeam(Team team){
            mTeam =team;
            mTeamNameTextView.setText(mTeam.getTeamName());
            mTextViewDriver1.setText(mTeam.getDrivers()[0]);
            mTextViewDriver2.setText(mTeam.getDrivers()[1]);
        }


        @Override
        public void onClick(View v) {
            Log.d(TAG,"onClick - value = "+getAdapterPosition());




/*
            mCheckBox1 = (CheckBox) v.findViewById(R.id.list_checkbox_driver1);
            mCheckBox1.toggle();

            mCheckBox2 = (CheckBox) v.findViewById(R.id.list_checkbox_driver2);
            mCheckBox2.toggle();
*/



            /*Intent data=new Intent();
            data.putExtra(EXTRA_DRIVER1,getAdapterPosition());
            getActivity().setResult(RESULT_OK, data);
            mUserDriverCount++;

            if (mUserDriverCount>=2) {
                getActivity().finish();
            }*/
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
