package com.nandohidayat.app.inputdatabarang;

public class Barang {
    private String KodeBarang;
    private String NamaBarang;
    private double HargaBeli;
    private double HargaJual;
    private double Stok;

    public Barang(String kodeBarang, String namaBarang, double hargaBeli, double hargaJual, double stok) {
        KodeBarang = kodeBarang;
        NamaBarang = namaBarang;
        HargaBeli = hargaBeli;
        HargaJual = hargaJual;
        Stok = stok;
    }

    public String getKodeBarang() {
        return KodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        KodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return NamaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        NamaBarang = namaBarang;
    }

    public double getHargaBeli() {
        return HargaBeli;
    }

    public void setHargaBeli(double hargaBeli) {
        HargaBeli = hargaBeli;
    }

    public double getHargaJual() {
        return HargaJual;
    }

    public void setHargaJual(double hargaJual) {
        HargaJual = hargaJual;
    }

    public double getStok() {
        return Stok;
    }

    public void setStok(double stok) {
        Stok = stok;
    }
}
