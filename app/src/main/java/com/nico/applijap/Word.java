package com.nico.applijap;

public class Word {

    private Long id;
    private String name;
    private String type;
    private String katakana;
    private String kanji;
    private String presentPo;
    private String presentNeg;
    private String passePo;
    private String passeNeg;
    private String interro;

    public Word() {
    }

    public Word (String name, String type, String katakana, String kanji) {
        this.name = name;
        this.type = type;
        this.katakana = katakana;
        this.kanji = kanji;
    }

    public Word(String name, String type, String katakana, String kanji,
                String presentPo, String presentNeg, String passePo, String passeNeg,
                String interro) {
        this.name = name;
        this.type = type;
        this.katakana = katakana;
        this.kanji = kanji;
        this.presentPo = presentPo;
        this.presentNeg = presentNeg;
        this.passePo = passePo;
        this.passeNeg = passeNeg;
        this.interro = interro;
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

    public String getPresentPo() {
        return presentPo;
    }

    public void setPresentPo(String presentPo) {
        this.presentPo = presentPo;
    }

    public String getPresentNeg() {
        return presentNeg;
    }

    public void setPresentNeg(String presentNeg) {
        this.presentNeg = presentNeg;
    }

    public String getPassePo() {
        return passePo;
    }

    public void setPassePo(String passePo) {
        this.passePo = passePo;
    }

    public String getPasseNeg() {
        return passeNeg;
    }

    public void setPasseNeg(String passeNeg) {
        this.passeNeg = passeNeg;
    }

    public String getInterro() {
        return interro;
    }

    public void setInterro(String interro) {
        this.interro = interro;
    }
}
