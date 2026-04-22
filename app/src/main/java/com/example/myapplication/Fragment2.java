package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    private HelloActivity helloActivity;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisFragmentView = inflater.inflate(R.layout.fragment_2, container, false);

        helloActivity = (HelloActivity) getActivity();

        Button button = thisFragmentView.findViewById(R.id.goToFragment1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helloActivity.showFragment1();
            }
        });

        return thisFragmentView;
    }
}