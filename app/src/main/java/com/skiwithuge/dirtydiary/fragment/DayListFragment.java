package com.skiwithuge.dirtydiary.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skiwithuge.dirtydiary.R;
import com.skiwithuge.dirtydiary.interfaces.OnAddDayClickListener;
import com.skiwithuge.dirtydiary.interfaces.OnDayClickListener;
import com.skiwithuge.dirtydiary.model.Day;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by skiwithuge on 4/3/17.
 */

public class DayListFragment extends Fragment {
    @BindView(R.id.day_recycler_view) RecyclerView mDayRecyclerView;
    //private DiaryAdapter mAdapter;
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

        //mDayRecyclerView = (RecyclerView) view
        //        .findViewById(R.id.day_recycler_view);
        mDayRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //TODO updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //TODO updateUI();
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
    public void addClick(){
        mOnAddDayClickListener.onAddDayClick();
    }

    public class DayHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Day mDay;

        public DayHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //TODO Complete
        }

        public void bindDay(Day day) {
            mDay = day;
            //TODO Complete

        }

        //TODO CHECK
        @Override
        public void onClick(View view) {
            mOnDayClickListener.onDaySelected(mDay);
        }
    }

    private class DayAdapter extends RecyclerView.Adapter<DayHolder> {
        private List<Day> mDays;
        private Context mContext;

        public DayAdapter(List<Day> days){
            mDays = days;
        }

        public DayAdapter(Context context, List<Day> days){
            mDays = days;
            mContext = context;
        }

        @Override
        public DayHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            View view = layoutInflater.inflate(R.layout.list_item_day, parent, false);
            return new DayHolder(view);
        }

        @Override
        public void onBindViewHolder(DayHolder holder, int position) {
            Day day = mDays.get(position);
            holder.bindDay(day);
        }

        @Override
        public int getItemCount() {
            return mDays.size();
        }

        public void setDays(List<Day> days) {
            mDays = days;
        }
    }
}
