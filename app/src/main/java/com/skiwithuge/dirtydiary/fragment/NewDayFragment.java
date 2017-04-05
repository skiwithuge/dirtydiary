package com.skiwithuge.dirtydiary.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skiwithuge.dirtydiary.R;

/**
 * Created by skiwithuge on 4/5/17.
 */

public class NewDayFragment extends Fragment {
    public static NewDayFragment newInstance(){
        NewDayFragment fragment = new NewDayFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_day, container, false);;

        return view;
    }
}
