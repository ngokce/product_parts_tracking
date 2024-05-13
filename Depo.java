package com.example.uruntakip1;

public class Depo {
    int depoKodu;
    private String depoAdi;
    private String sehir;
    private int kapasite;

    public Depo(int depoKodu, String depoAdi, String sehir, int kapasite) {
        this.depoKodu=depoKodu;
        this.depoAdi=depoAdi;
        this.sehir=sehir;
        this.kapasite=kapasite;
    }

    public int getDepoKodu() {
        return depoKodu;
    }

    public void setDepoKodu(int depoKodu) {
        this.depoKodu = depoKodu;
    }

    public String getDepoAdi() {
        return depoAdi;
    }

    public void setDepoAdi(String depoAdi) {
        this.depoAdi = depoAdi;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }
}