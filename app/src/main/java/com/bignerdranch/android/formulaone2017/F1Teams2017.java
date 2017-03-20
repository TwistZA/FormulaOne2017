package com.bignerdranch.android.formulaone2017;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avinash.Ganga on 16/03/17.
 */

public class F1Teams2017 {
    private List<Team> mTeamList;
    private static F1Teams2017 sTeams2017;

    public static F1Teams2017 get(Context context){
        if (sTeams2017==null){
            sTeams2017=new F1Teams2017(context);
        }
        return sTeams2017;
    }



    private F1Teams2017(Context context) {
        mTeamList = new ArrayList<>(10);

        /* Init 2017 team details */
        mTeamList.add(new Team("Ferrari", new String[]{"Sebastian Vettel", "Kimi Räikkönen"},"Ferrari",R.drawable.ferrari5));
        mTeamList.add(new Team("Haas", new String[]{"Romain Grosjean", "Kevin Magnussen"},"Ferrari",R.drawable.haasf1logo1));
        mTeamList.add(new Team("Force India", new String[]{"Sergio Pérez", "Esteban Ocon"},"Mercedes",R.drawable.forceindia4));
        mTeamList.add(new Team("McLaren Honda", new String[]{"Stoffel Vandoorne", "Fernando Alonso"},"Honda",R.drawable.mclaren5));
        mTeamList.add(new Team("Mercedes", new String[]{"Lewis Hamilton", "Valtteri Bottas"},"Mercedes",R.drawable.mercedes2));
        mTeamList.add(new Team("Red Bull Racing", new String[]{"Daniel Ricciardo", "Max Verstappen"},"TAG Heuer",R.drawable.redbull5));
        mTeamList.add(new Team("Renault", new String[]{"Nico Hülkenberg", "Jolyon Palmer"},"Renault",R.drawable.renaultsportf1logo230x90));
        mTeamList.add(new Team("Sauber", new String[]{"Marcus Ericsson", "Pascal Wehrlein"},"Ferrari",R.drawable.sauber4));
        mTeamList.add(new Team("Toro Rosso", new String[]{"Daniil Kvyat", "Carlos Sainz Jr"},"Renault",R.drawable.tororosso5));
        mTeamList.add(new Team("Williams", new String[]{"Lance Stroll", "Felipe Massa"},"Mercedes",R.drawable.williams6));

    }

    public List<Team> getTeamList() {
        return this.mTeamList;
    }
}
