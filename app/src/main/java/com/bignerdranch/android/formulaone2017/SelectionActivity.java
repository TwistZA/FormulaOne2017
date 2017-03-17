package com.bignerdranch.android.formulaone2017;

import android.support.v4.app.Fragment;


/**
 * Created by Avinash.Ganga on 17/03/17.
 */

public class SelectionActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new SelectionFragment();
    }
}
