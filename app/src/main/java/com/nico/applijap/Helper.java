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

    public static void getJson(InputStream inputStream, final VocaListener listener) {
        String json;
        List<Word> wordList = new ArrayList<>();
        try {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String name = object.getString("name");
                String type = object.getString("type");
                String katakana = object.getString("katakana");
                String kanji = object.getString("kanji");
                if (type.equalsIgnoreCase("nom")) {
                    Word word = new Word(name, type, katakana, kanji);
                    wordList.add(word);
                } else {
                    String presentPo = object.getString("presentpo");
                    String presentNeg = object.getString("presentneg");
                    String passePo = object.getString("passepo");
                    String passeNeg = object.getString("passeneg");
                    String interro = object.getString("interro");
                    Word word = new Word(name, type, katakana, kanji, presentPo, presentNeg,
                            passePo, passeNeg, interro);
                    wordList.add(word);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        listener.onVocaLoaded(wordList);
    }

    public interface VocaListener {
        void onVocaLoaded(List<Word> wordList);
    }
}
