package com.yazokulu.stoktakip.model;

public class Urun {
    private static int sonId = 0;

    private final int id;
    private final String ad;
    private final String kategori;
    private final double fiyat;
    private int stokMiktari;

    public Urun(String ad, String kategori, double fiyat, int stokMiktari) {
        this.id = ++sonId;
        this.ad = ad;
        this.kategori = kategori;
        this.fiyat = fiyat;
        this.stokMiktari = stokMiktari;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public String getKategori() {
        return kategori;
    }

    public double getFiyat() {
        return fiyat;
    }

    public int getStokMiktari() {
        return stokMiktari;
    }

    public void stokArtir(int miktar) {
        stokMiktari += miktar;
    }

    public boolean stokAzalt(int miktar) {
        if (miktar > stokMiktari) {
            return false;
        }
        stokMiktari -= miktar;
        return true;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", kategori='" + kategori + '\'' +
                ", fiyat=" + fiyat +
                ", stokMiktari=" + stokMiktari +
                '}';
    }
}
