package com.nico.applijap;

public class Verbe extends Word {

    private String masuPresentPo;
    private String masuPresentNeg;
    private String masuPassePo;
    private String masuPasseNeg;
    private String neutrePresentPo;
    private String neutrePresentNeg;
    private String neutrePassePo;
    private String neutrePasseNeg;
    private String tePresentPo;
    private String tePresentNeg;
    private String tePassePo;
    private String tePasseNeg;

    public Verbe() {
    }

    public Verbe(String name, String type, String katakana, String kanji,
                 String masuPresentPo, String masuPresentNeg, String masuPassePo, String masuPasseNeg,
                 String neutrePresentPo, String neutrePresentNeg, String neutrePassePo, String neutrePasseNeg,
                 String tePresentPo, String tePresentNeg, String tePassePo, String tePasseNeg) {
        super(name, type, katakana, kanji);
        this.masuPresentPo = masuPresentPo;
        this.masuPresentNeg = masuPresentNeg;
        this.masuPassePo = masuPassePo;
        this.masuPasseNeg = masuPasseNeg;
        this.neutrePresentPo = neutrePresentPo;
        this.neutrePresentNeg = neutrePresentNeg;
        this.neutrePassePo = neutrePassePo;
        this.neutrePasseNeg = neutrePasseNeg;
        this.tePresentPo = tePresentPo;
        this.tePresentNeg = tePresentNeg;
        this.tePassePo = tePassePo;
        this.tePasseNeg = tePasseNeg;
    }

    public String getMasuPresentPo() {
        return masuPresentPo;
    }

    public void setMasuPresentPo(String masuPresentPo) {
        this.masuPresentPo = masuPresentPo;
    }

    public String getMasuPresentNeg() {
        return masuPresentNeg;
    }

    public void setMasuPresentNeg(String masuPresentNeg) {
        this.masuPresentNeg = masuPresentNeg;
    }

    public String getMasuPassePo() {
        return masuPassePo;
    }

    public void setMasuPassePo(String masuPassePo) {
        this.masuPassePo = masuPassePo;
    }

    public String getMasuPasseNeg() {
        return masuPasseNeg;
    }

    public void setMasuPasseNeg(String masuPasseNeg) {
        this.masuPasseNeg = masuPasseNeg;
    }

    public String getNeutrePresentPo() {
        return neutrePresentPo;
    }

    public void setNeutrePresentPo(String neutrePresentPo) {
        this.neutrePresentPo = neutrePresentPo;
    }

    public String getNeutrePresentNeg() {
        return neutrePresentNeg;
    }

    public void setNeutrePresentNeg(String neutrePresentNeg) {
        this.neutrePresentNeg = neutrePresentNeg;
    }

    public String getNeutrePassePo() {
        return neutrePassePo;
    }

    public void setNeutrePassePo(String neutrePassePo) {
        this.neutrePassePo = neutrePassePo;
    }

    public String getNeutrePasseNeg() {
        return neutrePasseNeg;
    }

    public void setNeutrePasseNeg(String neutrePasseNeg) {
        this.neutrePasseNeg = neutrePasseNeg;
    }

    public String getTePresentPo() {
        return tePresentPo;
    }

    public void setTePresentPo(String tePresentPo) {
        this.tePresentPo = tePresentPo;
    }

    public String getTePresentNeg() {
        return tePresentNeg;
    }

    public void setTePresentNeg(String tePresentNeg) {
        this.tePresentNeg = tePresentNeg;
    }

    public String getTePassePo() {
        return tePassePo;
    }

    public void setTePassePo(String tePassePo) {
        this.tePassePo = tePassePo;
    }

    public String getTePasseNeg() {
        return tePasseNeg;
    }

    public void setTePasseNeg(String tePasseNeg) {
        this.tePasseNeg = tePasseNeg;
    }
}
