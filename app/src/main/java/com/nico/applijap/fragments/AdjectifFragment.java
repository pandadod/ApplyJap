package com.nico.applijap.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nico.applijap.Adjectif;
import com.nico.applijap.Helper;
import com.nico.applijap.R;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class AdjectifFragment extends Fragment {

    private AdjListener adjListener;
    private List<Adjectif> adjectifs;
    private Adjectif adjectifAnswer;
    private String tempsAnswer;
    private TextView tvKana;
    private TextView tvKanji;
    private TextView tvInstructions;
    private EditText etSolution;

    public AdjectifFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AdjListener adjListener = (AdjectifFragment.AdjListener) context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_adjectif, container, false);

        Button btSubmit = view.findViewById(R.id.btSubmit);

        tvKana = view.findViewById(R.id.tvKatakana);
        tvKanji = view.findViewById(R.id.tvKanji);
        tvInstructions = view.findViewById(R.id.tvInstructions);
        etSolution = view.findViewById(R.id.etSolution);
        try {
            adjectif(view);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String submit = etSolution.getText().toString();
                if (submit.equals(getSolution(adjectifAnswer, tempsAnswer))) {
                    randomAdjectif(adjectifs);
                    etSolution.getText().clear();
                } else {
                    Toast.makeText(view.getContext(), "Mauvaise réponse !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private void adjectif(View view) throws IOException, JSONException {
        InputStream inputStream = view.getContext().getAssets().open("lexique.json");
        Helper.getJsonAdjec(inputStream, new Helper.AdjeListener() {
            @Override
            public void onConjuLoaded(List<Adjectif> adjectifList) {
                adjectifs = adjectifList;
                randomAdjectif(adjectifList);
            }
        });
    }


    private void randomAdjectif(List<Adjectif> adjectifList) {
        Random r = new Random();
        int index = r.nextInt((adjectifList.size() - 1) + 1);
        Adjectif adjectif = adjectifList.get(index);
        adjectifAnswer = adjectif;
        String temps = temps();
        tempsAnswer = temps;
        tvKana.setText(adjectif.getKatakana());
        tvKanji.setText(adjectif.getKanji());
        tvInstructions.setText("Accordez l'adjectif au " + temps);
    }

    private String temps() {
        Random r = new Random();
        int index = r.nextInt(3 + 1);
        switch (index) {
            case 0: {
                return "présent positif";
            }
            case 1: {
                return "présent négatif";
            }
            case 2: {
                return "passé positif";
            }
            case 3: {
                return "passé négatif";
            }
        }
        return null;
    }

    private String getSolution(Adjectif adjectif, String temps) {
        switch (temps) {
            case "présent positif": {
                return adjectif.getPresentPo();
            }
            case "présent négatif": {
                return adjectif.getPresentNeg();
            }
            case "passé positif": {
                return adjectif.getPassePo();
            }
            case "passé négatif": {
                return adjectif.getPasseNeg();
            }
        }
        return null;
    }

    public interface AdjListener {
        void onAdjectifClicked();
    }
}
