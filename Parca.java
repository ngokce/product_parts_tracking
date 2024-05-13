package com.example.uruntakip1;

public class Parca {
    int parcaKodu;
    private String parcaAdi;
    int urunKodu;
    int fiyat;
    public Parca(int parcaKodu,String parcaAdi,int urunKodu,int fiyat) {
        this.parcaKodu=parcaKodu;
        this.parcaAdi=parcaAdi;
        this.urunKodu=urunKodu;
        this.fiyat=fiyat;
    }
    //constr

    public int getParcaKodu() {
        return parcaKodu;
    } //encaps

    public void setParcaKodu(int parcaKodu) {
        this.parcaKodu = parcaKodu;
    }

    public String getParcaAdi() {
        return parcaAdi;
    }

    public void setParcaAdi(String parcaAdi) {
        this.parcaAdi = parcaAdi;
    }

    public int getUrunKodu() {
        return urunKodu;
    }

    public void setUrunKodu(int urunKodu) {
        this.urunKodu = urunKodu;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
}
