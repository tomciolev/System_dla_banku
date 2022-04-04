package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//<Ctrl + Shift + T> – naciśnij tę kombinację na nazwie klasy dla której chcesz utworzyć test.
//<Alt + Insert>, naciśnięcie tego skrótu wewnątrz klasy grupującej testy pozwala nam w łatwy sposób stworzyć kolejny test.
//<Ctrl + Shift + F10> pozwala na uruchomienie testów jednostkowych wewnątrz IDE

class KontoTest {

    Konto konto;

    @BeforeEach
    void initialize() throws IllegalFormatException {
       konto = new Konto(new Wlasciciel("nazwa", "ulica", "00-000", "miasto"));
    }

    @Test
    void TestNumerKonta() {
        Assertions.assertEquals(101, konto.numerKonta);
    }

    @Test
    void TestSaldoRowne0() {
        Assertions.assertEquals(0, konto.saldoKonta);
    }

    @Test
    void WplacMoznaWyplacicTest() {
        konto.wplac(1000);
        Assertions.assertEquals(1000, konto.saldoKonta);
        Assertions.assertFalse(konto.moznaWyplacic(2000));
    }

    @Test
    void WyplacWyjatekTest() {
        Assertions.assertThrows(BrakPieniedzyException.class, () -> konto.wyplac(2000));
    }

    @Test
    void PrzelewaniePieniedzyTest() throws IllegalFormatException, BrakPieniedzyException {
        Konto konto2 = new Konto(new Wlasciciel("nazwa", "ulica", "00-000", "miasto"));
        konto.wplac(1000);
        Konto.przelej(konto, konto2, 500);
        Assertions.assertEquals(500, konto.saldoKonta);
        Assertions.assertEquals(500, konto2.saldoKonta);
    }
}