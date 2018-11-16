package com.nandohidayat.app.inputdatabarang;

public class Barang {
    private String KdBrg;
    private String NmBrg;
    private double HrgBeli;
    private double HrgJual;
    private double Stok;

    public Barang(String kdBrg, String nmBrg, double hrgBeli, double hrgJual, double stok) {
        KdBrg = kdBrg;
        NmBrg = nmBrg;
        HrgBeli = hrgBeli;
        HrgJual = hrgJual;
        Stok = stok;
    }

    public String getKdBrg() {
        return KdBrg;
    }

    public void setKdBrg(String kdBrg) {
        KdBrg = kdBrg;
    }

    public String getNmBrg() {
        return NmBrg;
    }

    public void setNmBrg(String nmBrg) {
        NmBrg = nmBrg;
    }

    public double getHrgBeli() {
        return HrgBeli;
    }

    public void setHrgBeli(double hrgBeli) {
        HrgBeli = hrgBeli;
    }

    public double getHrgJual() {
        return HrgJual;
    }

    public void setHrgJual(double hrgJual) {
        HrgJual = hrgJual;
    }

    public double getStok() {
        return Stok;
    }

    public void setStok(double stok) {
        Stok = stok;
    }
}
