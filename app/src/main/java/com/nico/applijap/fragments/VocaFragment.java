package com.nico.applijap.fragments;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nico.applijap.Helper;
import com.nico.applijap.R;
import com.nico.applijap.Word;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class VocaFragment extends Fragment {

    private VocaListener vocalistener;
    private TextView tvKata;
    private TextView tvKanji;
    private Word wordAnswer;
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_voca, container, false);
        final Button btResult1 = view.findViewById(R.id.btResult);
        final Button btResult2 = view.findViewById(R.id.btResult2);
        final Button btResult3 = view.findViewById(R.id.btResult3);
        final Button btResult4 = view.findViewById(R.id.btResult4);
        final List<Button> buttonList = new ArrayList<>();
        buttonList.add(btResult1);
        buttonList.add(btResult2);
        buttonList.add(btResult3);
        buttonList.add(btResult4);
        ImageButton ibReverso = view.findViewById(R.id.ibReverso);
        final int[] counterRevereso = {0};
        ibReverso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterRevereso[0]++;
                if (counterRevereso[0] % 2 == 0) {
                    japToFrench(view, buttonList);
                } else {
                    frenchToJap(view, buttonList);
                }
            }
        });
        tvKata = view.findViewById(R.id.tvKatakana);
        tvKanji = view.findViewById(R.id.tvKanji);

        japToFrench(view, buttonList);
        btResult1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceCheck(v, counterRevereso, btResult1, buttonList);
            }
        });
        btResult2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceCheck(v, counterRevereso, btResult2, buttonList);
            }
        });
        btResult3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceCheck(v, counterRevereso, btResult3, buttonList);
            }
        });
        btResult4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceCheck(v, counterRevereso, btResult4, buttonList);
            }
        });

        return view;
    }

    private void setQuestion(View view) {
        try {
            InputStream inputStream = view.getContext().getAssets().open("lexique.json");
            Helper.getJsonVoca(inputStream, new Helper.VocaListener() {
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void japToFrench(View view, List<Button> buttonList) {
        setQuestion(view);
        int countWord = 0;
        for (Word word : wordChoice) {
            String name = word.getName();
            buttonList.get(countWord).setText(name);
            buttonList.get(countWord).setTextColor(Color.WHITE);
            countWord++;
        }
        Random r = new Random();
        int index = r.nextInt((wordChoice.size() - 1) + 1);
        wordAnswer = wordChoice.get(index);
        tvKata.setText(wordAnswer.getKatakana());
        tvKanji.setText(wordAnswer.getKanji());
    }

    private void frenchToJap(View view, List<Button> buttonList) {
        setQuestion(view);
        int countWord = 0;
        for (Word word : wordChoice) {
            String kana = word.getKatakana();
            String kanji = word.getKanji();
            String name = kana + " / " + kanji;
            buttonList.get(countWord).setText(name);
            buttonList.get(countWord).setTextColor(Color.WHITE);
            countWord++;
        }
        Random r = new Random();
        int index = r.nextInt((wordChoice.size() - 1) + 1);
        wordAnswer = wordChoice.get(index);
        tvKata.setText(wordAnswer.getName());
        tvKanji.setText(null);
    }

    private void checkAnswerJapToFrench(View view, Button button, List<Button> buttonList) {
        if (button.getText().equals(wordAnswer.getName())) {
            japToFrench(view, buttonList);
        } else {
            for (int i = 0; i < buttonList.size(); i++) {
                if (buttonList.get(i).getText().equals(wordAnswer.getName())) {
                    buttonList.get(i).setTextColor(Color.GREEN);
                } else {
                    buttonList.get(i).setTextColor(Color.RED);
                }
            }
        }
    }

    private void checkAnswerFrenchToJap(View view, Button button, List<Button> buttonList) {
        String kana = wordAnswer.getKatakana();
        String kanji = wordAnswer.getKanji();
        String name = kana + " / " + kanji;
        if (button.getText().equals(name)) {
            frenchToJap(view, buttonList);
        } else {
            for (int i = 0; i < buttonList.size(); i++) {
                if (buttonList.get(i).getText().equals(name)) {
                    buttonList.get(i).setTextColor(Color.GREEN);
                } else {
                    buttonList.get(i).setTextColor(Color.RED);
                }
            }
        }
    }

    private void choiceCheck(View view, int[] counterRevereso, Button button, List<Button> buttonList) {
        if (counterRevereso[0] % 2 == 0) {
            checkAnswerJapToFrench(view, button, buttonList);
        } else {
            checkAnswerFrenchToJap(view, button, buttonList);
        }
    }

    public interface VocaListener {

        void onHomeClicked();

        void onGoodClick();
    }
}