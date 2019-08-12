package com.nico.applijap;

public class Adjectif extends Word {
    private String presentPo;
    private String presentNeg;
    private String passePo;
    private String passeNeg;

    public Adjectif() {
    }

    public Adjectif(String name, String type, String katakana, String kanji, String presentPo,
                    String presentNeg, String passePo, String passeNeg) {
        super(name, type, katakana, kanji);
        this.presentPo = presentPo;
        this.presentNeg = presentNeg;
        this.passePo = passePo;
        this.passeNeg = passeNeg;
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
}
