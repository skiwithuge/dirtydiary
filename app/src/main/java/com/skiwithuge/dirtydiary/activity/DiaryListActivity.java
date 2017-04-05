package com.skiwithuge.dirtydiary.activity;

import android.support.v4.app.Fragment;

import com.skiwithuge.dirtydiary.R;
import com.skiwithuge.dirtydiary.fragment.NewDayFragment;
import com.skiwithuge.dirtydiary.model.Day;
import com.skiwithuge.dirtydiary.fragment.DayListFragment;

/**
 * Created by skiwithuge on 11/19/16.
 */

public class DiaryListActivity extends SingleFragmentActivity implements DayListFragment.OnDayClickListener, DayListFragment.OnAddDayClickListener{
    @Override
    protected Fragment createFragment() {
        return new DayListFragment();
    }

    @Override
    public void onDaySelected(Day day) {
        //TODO
        /*Fragment dayFragment = DayFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, dayFragment)
                .addToBackStack(null)
                .commit();*/
    }

    @Override
    public void onAddDayClick() {
        Fragment newDayFragment = NewDayFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newDayFragment)
                .addToBackStack(null)
                .commit();
    }
}
