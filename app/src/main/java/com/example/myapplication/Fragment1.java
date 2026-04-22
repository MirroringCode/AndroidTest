package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    private HelloActivity helloActivity;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisFragmentView = inflater.inflate(R.layout.fragment_1, container, false);

        helloActivity = (HelloActivity) getActivity();
        Button button = thisFragmentView.findViewById(R.id.goToFragment2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helloActivity.showFragment2();
            }
        });

        return thisFragmentView;
    }
}