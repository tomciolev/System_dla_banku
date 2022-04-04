package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//<Ctrl + Shift + T> – naciśnij tę kombinację na nazwie klasy dla której chcesz utworzyć test.
//<Alt + Insert>, naciśnięcie tego skrótu wewnątrz klasy grupującej testy pozwala nam w łatwy sposób stworzyć kolejny test.
//<Ctrl + Shift + F10> pozwala na uruchomienie testów jednostkowych wewnątrz IDE
class WlascicielTest {

    Wlasciciel wlasciciel;

    @BeforeEach
    void initialize() throws IllegalFormatException {
        wlasciciel = new Wlasciciel("nazwa", "ulica", "00-000", "miasto");
    }
    @Test
    void testKonstruktoraNazwa(){
        Assertions.assertEquals("nazwa", wlasciciel.getNazwa());
    }
    @Test()
    void setNazwa() {
        Assertions.assertThrows(IllegalFormatException.class, ()-> wlasciciel.setNazwa("a"));
    }

    @Test
     void setKod() {
        Assertions.assertThrows(IllegalFormatException.class, ()-> wlasciciel.setKod("11-222a"));
    }
    @Test
    void testKonstruktoraKod() throws IllegalFormatException {
        wlasciciel.setKod("11-111");
        Assertions.assertEquals("11-111", wlasciciel.getKod());
    }
}