package com.nico.applijap.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.nico.applijap.R;


public class VocaFragment extends Fragment {

    VocaListener vocalistener;

    public VocaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        vocalistener = (VocaListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_voca, container, false);

        Button btResult1 = view.findViewById(R.id.btResult);
        btResult1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vocalistener.onHomeClicked();
            }
        });

        return view;
    }

    public interface VocaListener {

        void onHomeClicked();

    }
}