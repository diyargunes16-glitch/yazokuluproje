package com.yazokulu.stoktakip.service;

import com.yazokulu.stoktakip.model.Urun;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StokYonetimi {
    private final List<Urun> urunler = new ArrayList<>();

    public void urunEkle(Urun urun) {
        urunler.add(urun);
    }

    public void urunleriListele() {
        if (urunler.isEmpty()) {
            System.out.println("Kayitli urun yok.");
            return;
        }

        urunler.forEach(System.out::println);
    }

    public boolean stokGirisi(int urunId, int miktar) {
        Optional<Urun> urun = urunAra(urunId);
        urun.ifPresent(u -> u.stokArtir(miktar));
        return urun.isPresent();
    }

    public boolean stokCikisi(int urunId, int miktar) {
        Optional<Urun> urun = urunAra(urunId);
        return urun.filter(u -> u.stokAzalt(miktar)).isPresent();
    }

    public Optional<Urun> urunAra(int urunId) {
        return urunler.stream()
                .filter(urun -> urun.getId() == urunId)
                .findFirst();
    }
}
