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

import androidx.fragment.app.Fragment;

import com.nico.applijap.Helper;
import com.nico.applijap.R;
import com.nico.applijap.Verbe;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;


public class ConjuFragment extends Fragment {

    private List<Verbe> verbes;
    private Verbe verbeAnswer;
    private String formeAnswer;
    private String tempsAnswer;
    private TextView tvKana;
    private TextView tvKanji;
    private TextView tvInstructions;
    private EditText etSolution;

    public ConjuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ConjuListener conjulistener = (ConjuListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_conju, container, false);

        Button btSubmit = view.findViewById(R.id.btSubmit);

        tvKana = view.findViewById(R.id.tvKatakana);
        tvKanji = view.findViewById(R.id.tvKanji);
        tvInstructions = view.findViewById(R.id.tvInstructions);
        etSolution = view.findViewById(R.id.etSolution);
        try {
            conju(view);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String submit = etSolution.getText().toString();
                if (submit.equals(getSolution(verbeAnswer, formeAnswer, tempsAnswer))) {
                    randomVerbe(verbes);
                    etSolution.getText().clear();
                } else {
                    Toast.makeText(view.getContext(), "Mauvaise réponse !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private void conju(View view) throws IOException, JSONException {
        InputStream inputStream = view.getContext().getAssets().open("lexique.json");
        Helper.getJsonConju(inputStream, new Helper.ConjuListener() {
            @Override
            public void onConjuLoaded(List<Verbe> verbeList) {
                verbes = verbeList;
                randomVerbe(verbeList);
            }
        });
    }

    private void randomVerbe(List<Verbe> verbeList) {
        Random r = new Random();
        int index = r.nextInt((verbeList.size() - 1) + 1);
        Verbe verbe = verbeList.get(index);
        verbeAnswer = verbe;
        String forme = forme();
        formeAnswer = forme;
        String temps = temps();
        tempsAnswer = temps;
        tvKana.setText(verbe.getKatakana());
        tvKanji.setText(verbe.getKanji());
        tvInstructions.setText("Conjuguer le verbe à la forme " + forme + " et au " + temps);
    }

    private String forme() {
        Random r = new Random();
        int index = r.nextInt(3 + 1);
        switch (index) {
            case 0: {
                return "masu";
            }
            case 1: {
                return "ta";
            }
            case 2: {
                return "nai";
            }
            case 3: {
                return "te";
            }
        }
        return null;
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

    private String getSolution(Verbe verbe, String forme, String temps) {
        if (forme.equals("masu") && temps.equals("présent positif")) {
            return verbe.getMasuPresentPo();
        }
        if (forme.equals("masu") && temps.equals("présent négatif")) {
            return verbe.getMasuPresentNeg();
        }
        if (forme.equals("masu") && temps.equals("passé positif")) {
            return verbe.getMasuPassePo();
        }
        if (forme.equals("masu") && temps.equals("passé négatif")) {
            return verbe.getMasuPasseNeg();
        }
        if (forme.equals("ta") && temps.equals("présent positif")) {
            return verbe.getTaPresentPo();
        }
        if (forme.equals("ta") && temps.equals("présent négatif")) {
            return verbe.getTaPresentNeg();
        }
        if (forme.equals("ta") && temps.equals("passé positif")) {
            return verbe.getTaPassePo();
        }
        if (forme.equals("ta") && temps.equals("passé négatif")) {
            return verbe.getTaPasseNeg();
        }
        if (forme.equals("nai") && temps.equals("présent positif")) {
            return verbe.getNaiPresentPo();
        }
        if (forme.equals("nai") && temps.equals("présent négatif")) {
            return verbe.getNaiPresentNeg();
        }
        if (forme.equals("nai") && temps.equals("passé positif")) {
            return verbe.getNaiPassePo();
        }
        if (forme.equals("nai") && temps.equals("passé négatif")) {
            return verbe.getNaiPasseNeg();
        }
        if (forme.equals("te") && temps.equals("présent positif")) {
            return verbe.getTePresentPo();
        }
        if (forme.equals("te") && temps.equals("présent négatif")) {
            return verbe.getTePresentNeg();
        }
        if (forme.equals("te") && temps.equals("passé positif")) {
            return verbe.getTePassePo();
        }
        if (forme.equals("te") && temps.equals("passé négatif")) {
            return verbe.getTePasseNeg();
        }
        return null;
    }

    public interface ConjuListener {

        void onHomeClicked();

    }
}