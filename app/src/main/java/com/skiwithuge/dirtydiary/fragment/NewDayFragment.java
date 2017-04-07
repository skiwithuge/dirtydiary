package com.skiwithuge.dirtydiary.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skiwithuge.dirtydiary.R;
import com.skiwithuge.dirtydiary.interfaces.OnSaveDayClickListener;
import com.skiwithuge.dirtydiary.model.QueryManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by skiwithuge on 4/5/17.
 */

public class NewDayFragment extends Fragment {
    @BindView(R.id.add_task_date)
    TextView mDate;
    @BindView(R.id.add_task_title)
    TextView mTitle;
    @BindView(R.id.add_task_content)
    TextView mContent;

    private QueryManager queryManager;
    private OnSaveDayClickListener mOnSaveDayClickListener;

    public static NewDayFragment newInstance() {
        return new NewDayFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mOnSaveDayClickListener = (OnSaveDayClickListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_day, container, false);
        ButterKnife.bind(this, view);

        queryManager = QueryManager.get(getActivity());

        return view;
    }

    @OnClick(R.id.fab_save)
    public void saveClick() {
        // TODO proper date management
        long date = mDate.getText().hashCode();
        String title = mTitle.getText().toString();
        String content = mContent.getText().toString();

        queryManager.saveDay(date, title, content);
        mOnSaveDayClickListener.onSaveDayClick();
    }
}
