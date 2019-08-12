package com.nico.applijap;

public abstract class Word {

    private Long id;
    private String name;
    private String type;
    private String katakana;
    private String kanji;

    public Word() {
    }

    public Word(String name, String type, String katakana, String kanji) {
        this.name = name;
        this.type = type;
        this.katakana = katakana;
        this.kanji = kanji;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKatakana() {
        return katakana;
    }

    public void setKatakana(String katakana) {
        this.katakana = katakana;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }
}
