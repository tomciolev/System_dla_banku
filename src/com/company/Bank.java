package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import static java.util.stream.Collectors.toList;

public class Bank implements Serializable {
    String nazwa;
    ArrayList<Konto> listaKont;

    public Bank() {
    }

    public Bank(String nazwa){
        this.nazwa = nazwa;
        listaKont = new ArrayList<>();
    }

    public void utworzKonto(Konto k)
    {
        listaKont.add(k);
    }
    public void usunKonto(long nrKonta)
    {
        listaKont.removeIf(konto -> konto.numerKonta == nrKonta);
    }
    public Konto podajKonto(long nrKonta)
    {
        for (Konto konto: listaKont) {
            if(konto.numerKonta == nrKonta)
                return konto;
        }
        return null;
    }
    public ArrayList<Konto> podajKonto(String nazwa)
    {
        return  (ArrayList<Konto>) listaKont.stream().filter(konto -> konto.wlasciciel.nazwa == nazwa).collect(toList());
    }
    public double saldoBanku()
    {
        double suma = 0;
        suma = listaKont.stream().map(konto -> konto.saldoKonta).reduce(0.0, Double::sum);
        return suma;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bank: ").append(nazwa);
        for (Konto konto: listaKont) {
            sb.append("\n");
            sb.append(konto.toString());
        }
        return sb.toString();
    }
    public void wyświetlWgSald() {
        ArrayList<Konto> sorted = new ArrayList<>();
        for (Konto konto : listaKont) {
            sorted.add(konto);
        }
        Collections.sort(sorted);
        System.out.println("Lista kont posortowana wedlug salda konta: ");
        for (Konto konto : sorted) {
            System.out.println(konto.toString());
        }
    }
    public void wyświetlWgNazw() {
        ArrayList<Konto> sorted = new ArrayList<>();
        for (Konto konto : listaKont) {
            sorted.add(konto);
        }
        Collections.sort(sorted, new NazwaComparator());
        System.out.println("Lista kont posortowana wedlug nazwy wlasciciela konta: ");
        for (Konto konto : sorted) {
            System.out.println(konto.toString());
        }
    }
    public void zapisz(String nazwa) {
        try{
            FileOutputStream plik = new FileOutputStream(nazwa);
            ObjectOutputStream out = new ObjectOutputStream(plik);
            out.writeObject(this);
            out.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
    public static Bank wczytaj(String nazwa)   {
        try {
            FileInputStream plik = new FileInputStream(nazwa);
            ObjectInputStream in = new ObjectInputStream(plik);
            Bank odczytany = (Bank) in.readObject();
            return odczytany;
        }catch(IOException e ) {
            System.out.println("IOException");
            return null;
        }
        catch (ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
            return null;
        }

    }
}
