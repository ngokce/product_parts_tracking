package com.example.uruntakip1;
//kalıtım inheritance
public class parcaBarkod extends Parca{
    int parcaBarkodNo;
    public parcaBarkod(int parcaKodu, String parcaAdi, int urunKodu, int fiyat,int parcaBarkodNo) {
        super(parcaKodu, parcaAdi, urunKodu, fiyat);
        this.parcaBarkodNo=parcaBarkodNo;
    }

    public int getParcaBarkodNo() {
        return parcaBarkodNo;
    }

    public void setParcaBarkodNo(int parcaBarkodNo) {
        this.parcaBarkodNo = parcaBarkodNo;
    }
}
