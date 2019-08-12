package com.nico.applijap;

public class Verbe extends Word {

    private String masuPresentPo;
    private String masuPresentNeg;
    private String masuPassePo;
    private String masuPasseNeg;
    private String taPresentPo;
    private String taPresentNeg;
    private String taPassePo;
    private String taPasseNeg;
    private String naiPresentPo;
    private String naiPresentNeg;
    private String naiPassePo;
    private String naiPasseNeg;
    private String tePresentPo;
    private String tePresentNeg;
    private String tePassePo;
    private String tePasseNeg;

    public Verbe() {
    }

    public Verbe(String name, String type, String katakana, String kanji,
                 String masuPresentPo, String masuPresentNeg, String masuPassePo, String masuPasseNeg,
                 String taPresentPo, String taPresentNeg, String taPassePo, String taPasseNeg,
                 String naiPresentPo, String naiPresentNeg, String naiPassePo, String naiPasseNeg,
                 String tePresentPo, String tePresentNeg, String tePassePo, String tePasseNeg) {
        super(name, type, katakana, kanji);
        this.masuPresentPo = masuPresentPo;
        this.masuPresentNeg = masuPresentNeg;
        this.masuPassePo = masuPassePo;
        this.masuPasseNeg = masuPasseNeg;
        this.taPresentPo = taPresentPo;
        this.taPresentNeg = taPresentNeg;
        this.taPassePo = taPassePo;
        this.taPasseNeg = taPasseNeg;
        this.naiPresentPo = naiPresentPo;
        this.naiPresentNeg = naiPresentNeg;
        this.naiPassePo = naiPassePo;
        this.naiPasseNeg = naiPasseNeg;
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

    public String getTaPresentPo() {
        return taPresentPo;
    }

    public void setTaPresentPo(String taPresentPo) {
        this.taPresentPo = taPresentPo;
    }

    public String getTaPresentNeg() {
        return taPresentNeg;
    }

    public void setTaPresentNeg(String taPresentNeg) {
        this.taPresentNeg = taPresentNeg;
    }

    public String getTaPassePo() {
        return taPassePo;
    }

    public void setTaPassePo(String taPassePo) {
        this.taPassePo = taPassePo;
    }

    public String getTaPasseNeg() {
        return taPasseNeg;
    }

    public void setTaPasseNeg(String taPasseNeg) {
        this.taPasseNeg = taPasseNeg;
    }

    public String getNaiPresentPo() {
        return naiPresentPo;
    }

    public void setNaiPresentPo(String naiPresentPo) {
        this.naiPresentPo = naiPresentPo;
    }

    public String getNaiPresentNeg() {
        return naiPresentNeg;
    }

    public void setNaiPresentNeg(String naiPresentNeg) {
        this.naiPresentNeg = naiPresentNeg;
    }

    public String getNaiPassePo() {
        return naiPassePo;
    }

    public void setNaiPassePo(String naiPassePo) {
        this.naiPassePo = naiPassePo;
    }

    public String getNaiPasseNeg() {
        return naiPasseNeg;
    }

    public void setNaiPasseNeg(String naiPasseNeg) {
        this.naiPasseNeg = naiPasseNeg;
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
