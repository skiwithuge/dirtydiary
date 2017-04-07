package com.skiwithuge.dirtydiary.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skiwithuge.dirtydiary.R;
import com.skiwithuge.dirtydiary.adapter.DayAdapter;
import com.skiwithuge.dirtydiary.interfaces.OnAddDayClickListener;
import com.skiwithuge.dirtydiary.interfaces.OnDayClickListener;
import com.skiwithuge.dirtydiary.interfaces.OnItemClickListener;
import com.skiwithuge.dirtydiary.model.Day;
import com.skiwithuge.dirtydiary.model.DayList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by skiwithuge on 4/3/17.
 */

public class DayListFragment extends Fragment implements OnItemClickListener<Day> {

    @BindView(R.id.day_recycler_view)
    RecyclerView mDayRecyclerView;

    private DayAdapter mAdapter;
    private OnDayClickListener mOnDayClickListener;
    private OnAddDayClickListener mOnAddDayClickListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mOnDayClickListener = (OnDayClickListener) context;
        mOnAddDayClickListener = (OnAddDayClickListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day_list, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDayRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        updateUI();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        DayList dl = DayList.get(getActivity());
        List<Day> days = dl.getDays();

        if (mAdapter == null) {
            mAdapter = new DayAdapter(days, this);
            mDayRecyclerView.setAdapter(mAdapter);
        } else {
            mDayRecyclerView.setAdapter(mAdapter);
            mAdapter.setDays(days);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //TODO complete
    }

    //TODO onSaveInstanceState

    @Override
    public void onDetach() {
        super.onDetach();
        mOnDayClickListener = null;
    }

    //TODO onCreateOptionMenu

    //TODO onOptionsItemSelected

    @OnClick(R.id.fab_add)
    public void addClick() {
        mOnAddDayClickListener.onAddDayClick();
    }


    @Override
    public void onItemClick(Day item) {
        mOnDayClickListener.onDaySelected(item);
    }

}
