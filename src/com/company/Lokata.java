package com.company;


import java.io.Serializable;

public class Lokata extends Konto implements Oprocentowalny, Serializable {

    public enum okres { ROCZNA, POLROCZNA, TRZYMIESIECZNA }
    okres okresLokaty;
    static long biezacyNumerKonta = 500;
    static double tablicaOprocentowania[] = {1.5, 1.2, 1};
    int liczbaKapitalizacji;
    double oprocentowanie;

    public Lokata(Wlasciciel wlasciciel, okres okresLokaty) {
        super(wlasciciel);
        this.okresLokaty = okresLokaty;
        this.numerKonta = ++biezacyNumerKonta;
        if(okresLokaty.name().equals("ROCZNA")){
            oprocentowanie = tablicaOprocentowania[0];
            liczbaKapitalizacji=12;
        }

        else if(okresLokaty.toString().equals("POLROCZNA")){
            oprocentowanie = tablicaOprocentowania[1];
            liczbaKapitalizacji = 6;
        }

        else{
            oprocentowanie = tablicaOprocentowania[2];
            liczbaKapitalizacji = 3;
        }


    }

    @Override
    public String toString() {
        return "Lokata: " + wlasciciel +
                ", saldoKonta=" + saldoKonta +
                ", numerKonta=" + numerKonta +
                ", okresLokaty=" + okresLokaty +
                ", oprocentowanie=" + oprocentowanie;
    }
    @Override
    public void oprocentuj() {
        double kapitalizacja = saldoKonta * Math.pow((1 + oprocentowanie/100/liczbaKapitalizacji),(1*liczbaKapitalizacji));
        saldoKonta = kapitalizacja;
    }
}
