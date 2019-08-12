package com.nico.applijap.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.nico.applijap.R;


public class ConjuFragment extends Fragment {

    ConjuListener conjulistener;

    public ConjuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        conjulistener = (ConjuListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conju, container, false);

        Button btSubmit = view.findViewById(R.id.btSubmit);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conjulistener.onHomeClicked();
            }
        });

        return view;
    }

    public interface ConjuListener {

        void onHomeClicked();

    }
}