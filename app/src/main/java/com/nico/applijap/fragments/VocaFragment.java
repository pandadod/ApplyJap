package com.nico.applijap.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.nico.applijap.Helper;
import com.nico.applijap.R;
import com.nico.applijap.Word;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class VocaFragment extends Fragment {

    VocaListener vocalistener;
    TextView tvKata;
    TextView tvKanji;
    private List<Word> wordChoice = new ArrayList<>();

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
        Button btResult2 = view.findViewById(R.id.btResult2);
        Button btResult3 = view.findViewById(R.id.btResult3);
        Button btResult4 = view.findViewById(R.id.btResult4);
        List<Button> buttonList = new ArrayList<>();
        buttonList.add(btResult1);
        buttonList.add(btResult2);
        buttonList.add(btResult3);
        buttonList.add(btResult4);
        tvKata = view.findViewById(R.id.tvKatakana);
        tvKanji = view.findViewById(R.id.tvKanji);

        setQuestion(view, buttonList);

        btResult1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vocalistener.onHomeClicked();
            }
        });

        return view;
    }

    private void setQuestion(View view, List<Button> buttonList) {
        try {
            InputStream inputStream = view.getContext().getAssets().open("lexique.json");
            Helper.getJson(inputStream, new Helper.VocaListener() {
                @Override
                public void onVocaLoaded(List<Word> wordList) {
                    wordChoice.clear();
                    int count = 0;
                    while (count < 4) {
                        Random r = new Random();
                        int index = r.nextInt((wordList.size() - 1) + 1);
                        Word word = wordList.get(index);
                        wordChoice.add(word);
                        count++;
                    }

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        int countWord = 0;
        for (Word word : wordChoice) {
            String name = word.getName();
            buttonList.get(countWord).setText(name);
            countWord++;
        }
        Random r = new Random();
        int index = r.nextInt((wordChoice.size() - 1) + 1);
        Word word = wordChoice.get(index);
        tvKata.setText(word.getKatakana());
        tvKanji.setText(word.getKanji());
    }

    public interface VocaListener {

        void onHomeClicked();

        void onSubmitClicked();

    }
}