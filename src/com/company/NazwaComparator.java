package com.company;

import java.util.Comparator;

public class NazwaComparator implements Comparator<Konto> {

    @Override
    public int compare(Konto o1, Konto o2) {
        return o1.wlasciciel.nazwa.compareTo(o2.wlasciciel.nazwa);
    }

}
