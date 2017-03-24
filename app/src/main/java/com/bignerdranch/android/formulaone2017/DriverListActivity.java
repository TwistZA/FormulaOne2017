package com.bignerdranch.android.formulaone2017;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

/**
 * Created by Avinash.Ganga on 2017/03/17.
 */

public class DriverListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new DriverListFragment();
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, DriverListActivity.class);
        return intent;
    }

}
