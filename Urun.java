package com.example.uruntakip1;

import java.util.ArrayList;

public class Urun {
    private int urunKodu; //1001 1002
    private String urunAdi; //Laptop Mouse
    private int urunMiktar; //550
    public Urun(int urunKodu,String urunAdi,int urunMiktar) {
        this.urunKodu=urunKodu;
        this.urunAdi=urunAdi;
        this.urunMiktar=urunMiktar;

    }

    public int getUrunKodu() {
        return urunKodu;
    }

    public void setUrunKodu(int urunKodu) {
        this.urunKodu = urunKodu;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }


    public int getUrunMiktar() {
        return urunMiktar;
    }

    public void setUrunMiktar(int urunMiktar) {
        this.urunMiktar = urunMiktar;
    }

}

