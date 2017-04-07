package com.skiwithuge.dirtydiary.activity;

import android.support.v4.app.Fragment;

import com.skiwithuge.dirtydiary.fragment.DayFragment;
import com.skiwithuge.dirtydiary.fragment.DayListFragment;
import com.skiwithuge.dirtydiary.fragment.NewDayFragment;
import com.skiwithuge.dirtydiary.interfaces.OnAddDayClickListener;
import com.skiwithuge.dirtydiary.interfaces.OnDayClickListener;
import com.skiwithuge.dirtydiary.interfaces.OnSaveDayClickListener;
import com.skiwithuge.dirtydiary.model.Day;

/**
 * Created by skiwithuge on 11/19/16.
 */

public class DiaryListActivity extends SingleFragmentActivity implements OnDayClickListener,
        OnAddDayClickListener, OnSaveDayClickListener {
    @Override
    protected Fragment createFragment() {
        return new DayListFragment();
    }

    @Override
    public void onDaySelected(Day day) {
        Fragment dayFragment = new DayFragment(day);
        replaceFragment(dayFragment);
    }

    @Override
    public void onAddDayClick() {
        Fragment newDayFragment = NewDayFragment.newInstance();
        replaceFragment(newDayFragment);
    }

    @Override
    public void onSaveDayClick() {
        Fragment dayListFragment = new DayListFragment();
        replaceFragment(dayListFragment);
    }
}
