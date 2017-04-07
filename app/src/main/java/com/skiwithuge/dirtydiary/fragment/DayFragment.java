package com.skiwithuge.dirtydiary.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skiwithuge.dirtydiary.R;
import com.skiwithuge.dirtydiary.model.Day;
import com.skiwithuge.dirtydiary.model.QueryManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by skiwithuge on 4/6/17.
 */

public class DayFragment extends Fragment {
    private static final String KEY_DAY_ID = "day_id";

    @BindView(R.id.date)
    TextView mDate;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.content)
    TextView mContent;

    private Day mDay;

    public static DayFragment newInstance(long dayId) {
        DayFragment fragment = new DayFragment();
        Bundle args = new Bundle(1);
        args.putLong(KEY_DAY_ID, dayId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        long id = getArguments().getLong(KEY_DAY_ID);
        mDay = QueryManager.get(getContext()).getDay(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day, container, false);
        ButterKnife.bind(this, view);

        mDate.setText(Long.toString(mDay.getDate()));
        return view;
    }

}