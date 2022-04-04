package com.company;

import java.io.Serializable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
//ctrl alt q - generuje ladnie wygladajace opisy
/**
 * klasa opisuje Właściciela
 * @author tomec
 */
public class Wlasciciel implements Serializable {

    String nazwa;
    String ulica;
    String kod;
    String miejscowosc;

    /**
     * @return nazwa właściciela
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * @param nazwa - ustawia nazwę właściciela
     * @throws IllegalFormatException
     */
    public void setNazwa(String nazwa) throws IllegalFormatException {
        if(nazwa.length() >= 3)
            this.nazwa = nazwa;
        else
            throw new IllegalFormatException("Nazwa powinna się składać z przynajmniej trzech znaków");
    }

    /**
     *
     * @return nazwę wlasciciela
     */
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) throws IllegalFormatException {
        if(ulica.length() > 3)
            this.ulica = ulica;
        else
            throw new IllegalFormatException("Ulica powinna się składać z przynajmniej trzech znaków");
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) throws IllegalFormatException {
        if (Pattern.matches("\\d{2}-\\d{3}", kod))
            this.kod = kod;
        else
            throw new IllegalFormatException();
    }
    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) throws IllegalFormatException {
        if(miejscowosc.length() > 3)
            this.miejscowosc = miejscowosc;
        else
            throw new IllegalFormatException("Miejscowość powinna się składać z przynajmniej trzech znaków");
    }

    public Wlasciciel(String nazwa, String ulica, String kod, String miejscowosc) throws IllegalFormatException {
            setKod(kod);
            setMiejscowosc(miejscowosc);
            setNazwa(nazwa);
            setUlica(ulica);

    }

    @Override
    public String toString() {
        return "Wlasciciel: " + nazwa + " " + kod + " " + ulica + " " + miejscowosc;
    }
}
