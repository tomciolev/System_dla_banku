package com.company;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Konto implements Comparable<Konto>, Serializable {

    Wlasciciel wlasciciel;
    double saldoKonta;
    long numerKonta;
    static long biezacyNumerKonta = 100;

    public Konto() {
    }

    public Konto(Wlasciciel wlasciciel) {
        this.wlasciciel = wlasciciel;
        saldoKonta = 0;
        numerKonta = ++biezacyNumerKonta;
    }

    @Override
    public String toString() {
        Locale poland = new Locale("pl", "PL");
        Currency zloty = Currency.getInstance(poland);
        NumberFormat zlotyFormat = NumberFormat.getCurrencyInstance(poland);
        return "Konto: " +
                wlasciciel.toString() + " " +
                ", saldoKonta=" + zlotyFormat.format(saldoKonta) + " " +
                ", numerKonta=" + numerKonta;
    }
    public void wplac(double kwota){
        saldoKonta += kwota;
    }
    public boolean moznaWyplacic(double kwota){
        if(kwota <= saldoKonta)
            return true;
        else
            return false;
    }
    public void wyplac(double kwota) throws BrakPieniedzyException {
        if(moznaWyplacic(kwota))
            saldoKonta -= kwota;
        else
            throw new BrakPieniedzyException("Masz niewystarczające środki na koncie");
    }
    public static void przelej(Konto k1, Konto k2, double kwota) throws BrakPieniedzyException {
        if(k1.moznaWyplacic(kwota)){
            k1.saldoKonta -= kwota;
            k2.saldoKonta += kwota;
        }
        else
            throw new BrakPieniedzyException("Masz niewystarczające środki na koncie");
    }

    @Override
    public int compareTo(Konto o) {
        return Double.compare(this.saldoKonta, o.saldoKonta);
    }
}
