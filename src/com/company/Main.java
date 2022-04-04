package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws BrakPieniedzyException {
        Wlasciciel w1 = null;
        Wlasciciel w2 = null;
        try {
            w1 = new Wlasciciel("Tomek", "Jablonki", "22-345", "Krakow");
            w2 = new Wlasciciel("Jakub", "Dluga", "90-908", "Krakow");
        } catch (IllegalFormatException e) {
            e.printStackTrace();
        }
        System.out.println(w1.toString());
        System.out.println(w2.toString());
        Konto k1 = new Konto(w1);
        Konto k2 = new Konto(w2);
        Konto k3 = new Konto(w2);
        Konto k4 = new Konto(w1);
        // TESTOWANIE KONT
        System.out.println(k1.toString());
        System.out.println(k2.toString());
        k1.wplac(50);
        k3.wplac(70);
        k4.wplac(580);
        System.out.println("Po wpłaceniu 50 zl: ");
        System.out.println(k1.toString());
        System.out.println("Czy mozna wyplacic 100 zl? ");
        System.out.println(k1.moznaWyplacic(100));
        k1.wyplac(20);
        System.out.println("Po wyplaceniu 20 zl:");
        System.out.println(k1.toString());
        Konto.przelej(k1,k2,20);
        System.out.println("Po przelaniu z k1 na k2 20 zl:");
        System.out.println(k1.toString());
        System.out.println(k2.toString());
        //banki
        Bank b1 = new Bank("BNP");
        b1.utworzKonto(k1);
        b1.utworzKonto(k2);
        b1.utworzKonto(k3);
        b1.utworzKonto(k4);
        System.out.println(b1.toString());
        b1.usunKonto(102);
        System.out.println(b1.toString());
        System.out.println("Po nazwie: ");
        for (Konto konto : b1.podajKonto("Tomek")){
            System.out.println(konto.toString());
        }
        System.out.println("Suma sald kont w banku " + b1.nazwa + " wynosi: " +  b1.saldoBanku() + "zl");
        //LOKATY
        Lokata l1 = new Lokata(w1, Lokata.okres.POLROCZNA);
        Lokata l2 = new Lokata(w2, Lokata.okres.ROCZNA);
        System.out.println("LOKATY");
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        l1.wplac(2000);
        b1.utworzKonto(l1);
        b1.utworzKonto(l2);
        System.out.println(b1.toString());
        //SORTOWANIE
        b1.wyświetlWgSald();
        b1.wyświetlWgNazw();
        System.out.println("OPROCENTOWANIE");
        System.out.println(l1.toString());
        l1.oprocentuj();
        System.out.println(l1.toString());
        b1.zapisz("dane.bin");
        Bank b3 = new Bank("ELO");
        b3 = Bank.wczytaj("dane.bin");
        System.out.println("ODCZYTANY");
        System.out.println(b1.toString());
        System.out.println(b3.toString());

    }
}
