package com.nico.applijap.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.nico.applijap.R;


public class HomeFragment extends Fragment {

    HomeListener listener;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (HomeListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btGallery = view.findViewById(R.id.btGallery);
        btGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onGalleryClicked();
            }
        });

        return view;
    }

    public interface HomeListener {

        void onGalleryClicked();
    }
}