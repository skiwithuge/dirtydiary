package com.skiwithuge.dirtydiary.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skiwithuge.dirtydiary.R;
import com.skiwithuge.dirtydiary.interfaces.OnItemClickListener;
import com.skiwithuge.dirtydiary.model.Day;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.DayHolder> {

    private List<Day> days;
    private OnItemClickListener<Day> listener;

    public DayAdapter(List<Day> days, OnItemClickListener<Day> listener) {
        this.days = days;
        this.listener = listener;
    }

    @Override
    public DayHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_day, parent, false);
        return new DayHolder(view);
    }

    @Override
    public void onBindViewHolder(DayHolder holder, int position) {
        holder.bindDay(days.get(position));
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    class DayHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card_date)
        TextView mDate;
        @BindView(R.id.card_title)
        TextView mTitle;

        DayHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindDay(final Day day) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) listener.onItemClick(day);
                }
            });

            mDate.setText(day.getDate());
            mTitle.setText(day.getTitle());
        }
    }
}
