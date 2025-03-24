package hu.szamalk.Modell;

import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;
import java.util.List;

public class Tantargy implements Comparable<Tantargy>, Serializable {
    private String nev, tanar, csak_vizsga;
    private int kredit, felev;

    public Tantargy(String nev, String tanar, String csak_vizsga, int kredit, int felev) {
        this.nev = nev;
        this.tanar = tanar;
        this.csak_vizsga = csak_vizsga;
        this.kredit = kredit;
        this.felev = felev;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTanar() {
        return tanar;
    }

    public void setTanar(String tanar) {
        this.tanar = tanar;
    }

    public String getCsak_vizsga() {
        return csak_vizsga;
    }

    public void setCsak_vizsga(String csak_vizsga) {
        this.csak_vizsga = csak_vizsga;
    }

    public int getKredit() {
        return kredit;
    }

    public void setKredit(int kredit) {
        this.kredit = kredit;
    }

    public int getFelev() {
        return felev;
    }

    public void setFelev(int felev) {
        this.felev = felev;
    }

    @Override
    public int compareTo(Tantargy masik) {
        Collator coll = Collator.getInstance();
        return coll.compare(this.nev, masik.nev);
    }


    public static nevComparator rendezNev(){
        return new nevComparator();
    }

    private static class nevComparator implements Comparator<Tantargy> {
        @Override
        public int compare(Tantargy egyik, Tantargy masik) {
            Collator coll = Collator.getInstance();
            return coll.compare(egyik.nev, masik.nev);
        }
    }

    public static kreditComparator rendezKredit(){
        return new kreditComparator();
    }

    private static class kreditComparator implements Comparator<Tantargy>{

        @Override
        public int compare(Tantargy egyik, Tantargy masik) {
            return egyik.kredit - masik.kredit;
        }
    }
}
