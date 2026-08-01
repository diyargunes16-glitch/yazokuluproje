package com.yazokulu.stoktakip;

import com.yazokulu.stoktakip.model.Urun;
import com.yazokulu.stoktakip.service.StokYonetimi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StokYonetimi stokYonetimi = new StokYonetimi();

        while (true) {
            System.out.println("\n=== Stok Takip Programi ===");
            System.out.println("1. Urun ekle");
            System.out.println("2. Urunleri listele");
            System.out.println("3. Stok girisi yap");
            System.out.println("4. Stok cikisi yap");
            System.out.println("5. Urun ara");
            System.out.println("0. Cikis");
            System.out.print("Secim: ");

            String secim = scanner.nextLine();

            switch (secim) {
                case "1" -> urunEkle(scanner, stokYonetimi);
                case "2" -> stokYonetimi.urunleriListele();
                case "3" -> stokHareketi(scanner, stokYonetimi, true);
                case "4" -> stokHareketi(scanner, stokYonetimi, false);
                case "5" -> urunAra(scanner, stokYonetimi);
                case "0" -> {
                    System.out.println("Program kapatildi.");
                    return;
                }
                default -> System.out.println("Gecersiz secim.");
            }
        }
    }

    private static void urunEkle(Scanner scanner, StokYonetimi stokYonetimi) {
        System.out.print("Urun adi: ");
        String ad = scanner.nextLine();
        System.out.print("Kategori: ");
        String kategori = scanner.nextLine();
        System.out.print("Fiyat: ");
        double fiyat = Double.parseDouble(scanner.nextLine());
        System.out.print("Baslangic stok: ");
        int stok = Integer.parseInt(scanner.nextLine());

        stokYonetimi.urunEkle(new Urun(ad, kategori, fiyat, stok));
        System.out.println("Urun eklendi.");
    }

    private static void stokHareketi(Scanner scanner, StokYonetimi stokYonetimi, boolean giris) {
        System.out.print("Urun ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Miktar: ");
        int miktar = Integer.parseInt(scanner.nextLine());

        boolean sonuc = giris
                ? stokYonetimi.stokGirisi(id, miktar)
                : stokYonetimi.stokCikisi(id, miktar);

        System.out.println(sonuc ? "Islem basarili." : "Islem basarisiz.");
    }

    private static void urunAra(Scanner scanner, StokYonetimi stokYonetimi) {
        System.out.print("Urun ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        stokYonetimi.urunAra(id)
                .ifPresentOrElse(
                        urun -> System.out.println(urun),
                        () -> System.out.println("Urun bulunamadi.")
                );
    }
}
