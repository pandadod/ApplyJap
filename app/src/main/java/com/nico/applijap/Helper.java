package com.nico.applijap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static void getJsonVoca(InputStream inputStream, final VocaListener listener) throws JSONException {

        List<Word> wordList = new ArrayList<>();
        JSONArray jsonArray = initiateJson(inputStream);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            String name = object.getString("name");
            String type = object.getString("type");
            String katakana = object.getString("katakana");
            String kanji = object.getString("kanji");
            if (type.equalsIgnoreCase("nom")) {
                Nom nom = new Nom(name, type, katakana, kanji);
                wordList.add(nom);
            } else if (type.equalsIgnoreCase("adjectif")) {
                JSONObject declinaison = object.getJSONObject("declinaison");
                String presentPo = declinaison.getString("presentpo");
                String presentNeg = declinaison.getString("presentneg");
                String passePo = declinaison.getString("passepo");
                String passeNeg = declinaison.getString("passeneg");
                Adjectif adjectif = new Adjectif(name, type, katakana, kanji, presentPo, presentNeg,
                        passePo, passeNeg);
                wordList.add(adjectif);
            } else {
                JSONObject masu = object.getJSONObject("masu");
                String masuPresentPo = masu.getString("presentpo");
                String masuPresentNeg = masu.getString("presentneg");
                String masuPassePo = masu.getString("passepo");
                String masuPasseNeg = masu.getString("passeneg");
                JSONObject ta = object.getJSONObject("ta");
                String taPresentPo = ta.getString("presentpo");
                String taPresentNeg = ta.getString("presentneg");
                String taPassePo = ta.getString("passepo");
                String taPasseNeg = ta.getString("passeneg");
                JSONObject nai = object.getJSONObject("nai");
                String naiPresentPo = nai.getString("presentpo");
                String naiPresentNeg = nai.getString("presentneg");
                String naiPassePo = nai.getString("passepo");
                String naiPasseNeg = nai.getString("passeneg");
                JSONObject te = object.getJSONObject("te");
                String tePresentPo = te.getString("presentpo");
                String tePresentNeg = te.getString("presentneg");
                String tePassePo = te.getString("passepo");
                String tePasseNeg = te.getString("passeneg");

                Verbe verbe = new Verbe(name, type, katakana, kanji,
                        masuPresentPo, masuPresentNeg, masuPassePo, masuPasseNeg,
                        taPresentPo, taPresentNeg, taPassePo, taPasseNeg,
                        naiPresentPo, naiPresentNeg, naiPassePo, naiPasseNeg,
                        tePresentPo, tePresentNeg, tePassePo, tePasseNeg);
                wordList.add(verbe);
            }
        }
        listener.onVocaLoaded(wordList);
    }

    public static void getJsonConju(InputStream inputStream, final ConjuListener listener) throws JSONException {
        List<Verbe> verbeList = new ArrayList<>();
        JSONArray jsonArray = initiateJson(inputStream);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            String type = object.getString("type");
            if (type.equalsIgnoreCase("verbe")) {
                String name = object.getString("name");
                String katakana = object.getString("katakana");
                String kanji = object.getString("kanji");
                JSONObject masu = object.getJSONObject("masu");
                String masuPresentPo = masu.getString("presentpo");
                String masuPresentNeg = masu.getString("presentneg");
                String masuPassePo = masu.getString("passepo");
                String masuPasseNeg = masu.getString("passeneg");
                JSONObject ta = object.getJSONObject("ta");
                String taPresentPo = ta.getString("presentpo");
                String taPresentNeg = ta.getString("presentneg");
                String taPassePo = ta.getString("passepo");
                String taPasseNeg = ta.getString("passeneg");
                JSONObject nai = object.getJSONObject("nai");
                String naiPresentPo = nai.getString("presentpo");
                String naiPresentNeg = nai.getString("presentneg");
                String naiPassePo = nai.getString("passepo");
                String naiPasseNeg = nai.getString("passeneg");
                JSONObject te = object.getJSONObject("te");
                String tePresentPo = te.getString("presentpo");
                String tePresentNeg = te.getString("presentneg");
                String tePassePo = te.getString("passepo");
                String tePasseNeg = te.getString("passeneg");

                Verbe verbe = new Verbe(name, type, katakana, kanji,
                        masuPresentPo, masuPresentNeg, masuPassePo, masuPasseNeg,
                        taPresentPo, taPresentNeg, taPassePo, taPasseNeg,
                        naiPresentPo, naiPresentNeg, naiPassePo, naiPasseNeg,
                        tePresentPo, tePresentNeg, tePassePo, tePasseNeg);
                verbeList.add(verbe);
            }
        }
        listener.onConjuLoaded(verbeList);
    }

    public static void getJsonAdjec(InputStream inputStream, final AdjeListener listener) throws JSONException {
        List<Adjectif> adjectifList = new ArrayList<>();
        JSONArray jsonArray = initiateJson(inputStream);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            String type = object.getString("type");
            if (type.equalsIgnoreCase("adjectif")) {
                String name = object.getString("name");
                String katakana = object.getString("katakana");
                String kanji = object.getString("kanji");
                JSONObject declinaison = object.getJSONObject("declinaison");
                String presentPo = declinaison.getString("presentpo");
                String presentNeg = declinaison.getString("presentneg");
                String passePo = declinaison.getString("passepo");
                String passeNeg = declinaison.getString("passeneg");
                Adjectif adjectif = new Adjectif(name, type, katakana, kanji, presentPo, presentNeg,
                        passePo, passeNeg);
                adjectifList.add(adjectif);
            }
        }
        listener.onConjuLoaded(adjectifList);
    }

    private static JSONArray initiateJson(InputStream inputStream) {
        String json;
        JSONArray jsonArray = null;

        try {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, StandardCharsets.UTF_8);
            jsonArray = new JSONArray(json);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }


    public interface VocaListener {
        void onVocaLoaded(List<Word> wordList);
    }

    public interface ConjuListener {
        void onConjuLoaded(List<Verbe> verbeListList);
    }

    public interface AdjeListener {
        void onConjuLoaded(List<Adjectif> adjectifList);
    }
}
