package com.skiwithuge.dirtydiary.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skiwithuge.dirtydiary.R;
import com.skiwithuge.dirtydiary.model.Day;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by skiwithuge on 4/6/17.
 */

public class DayFragment extends Fragment {
    @BindView(R.id.date) TextView mDate;
    @BindView(R.id.title) TextView mTitle;
    @BindView(R.id.content) TextView mContent;

    Day mDay;
    public static DayFragment newInstance(){
        DayFragment fragment = new DayFragment();
        return fragment;
    }

    public DayFragment(){

    }
    public DayFragment(Day d){
        mDay = d;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day, container, false);;
        ButterKnife.bind(this, view);

        mDate.setText(mDay.getDate());
        return view;
    }

}