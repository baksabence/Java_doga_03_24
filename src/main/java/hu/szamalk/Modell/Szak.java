package hu.szamalk.Modell;

import java.io.*;
import java.util.*;

public class Szak{
    private String nev;
    private transient UUID id;
    private List<String> tantargyak;

    public Szak(String sor){
        String[] adatok = sor.split(";");
        String nev = adatok[0];
        this.nev = nev;
        String tantargyakSor = adatok[1];
        String[] tantargyak = tantargyakSor.split(",");
        this.tantargyak = new ArrayList<>();
        for (String tantargy : tantargyak) {
            this.tantargyak.add(tantargy);
        }
        ujIdGeneralas();
    }

    public Szak(String nev, String tantargy) {
        this(nev, new ArrayList<>());
        tantargyak.add(tantargy);
    }

    public Szak(String nev, List<String> tantargyak) {
        this.nev = nev;
        this.tantargyak = tantargyak;
        ujIdGeneralas();
    }

    public void ujIdGeneralas(){
        id = UUID.randomUUID();
    }

   void szakKiirasa() {
        tantargyak = new ArrayList<>();
        Tantargy t1 = new Tantargy("informatika", "rokarudi", "nem", 2, 2);
        Tantargy t2 = new Tantargy("matematika", "Kiss Ádám", "nem", 4, 2);
        String fajl = "targyak.dat";
       try(ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream(fajl))){
           objKi.writeObject(t1);
           objKi.writeObject(t2);
           System.out.println(t1);
           System.out.println(t2);
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       }

       void szakBeolvasasa(){
           String fajl = "targyak.dat";
           try(ObjectInputStream objBe = new ObjectInputStream(new FileInputStream(fajl))){
           Tantargy t;
           t = (Tantargy) objBe.readObject();
           ujIdGeneralas();
           System.out.println(t);
       } catch (IOException e) {
               throw new RuntimeException(e);
           } catch (ClassNotFoundException e) {
               throw new RuntimeException(e);
           }
       }


       private List<Tantargy> getTargyakNevSzerint(){
        List<Tantargy> nevek = new ArrayList<>();
        Tantargy t1 = new Tantargy("info", "rokarudi", "nem", 2, 3);
        Tantargy t2 = new Tantargy("matek", "ede", "igen", 4, 4);
        nevek.add((t1));
        nevek.add((t2));
        nevek.sort(Tantargy.rendezNev());
        return nevek;
    }

    private List<Tantargy> getTargyakKreditSzerint(){
        List<Tantargy> kreditek = new ArrayList<>();
        Tantargy t1 = new Tantargy("info", "rokarudi", "nem", 2, 3);
        Tantargy t2 = new Tantargy("matek", "ede", "igen", 4, 4);
        kreditek.add((t1));
        kreditek.add((t2));
        kreditek.sort(Tantargy.rendezNev());
        return kreditek;
    }

    void statisztika(){
        String fn = "statisztika.txt";
        String kulTargy = "kulonbozo targy:" + kulonbozoTargy();
        String szakKredit = "szak összes kredit értéke: " + kreditErtek();
    }

    private Set<String> kulonbozoTargy() {
        Set<String> kulTargyak = new HashSet<>();
        tantargyak.forEach(sor ->{
            String[] tomb = sor.split(",");
            for (String tantargy : tomb) {
                kulTargyak.add(tantargy);
            }
        });
        return kulTargyak;
    }


    private Map<String, String> kreditErtek() {
        Map<String, String> mm = new HashMap<>();
        tantargyak.forEach(tantargy ->{
            String kulcs = tantargy.getCsak_vizsga();
            if(mm.containsKey(kulcs)){

            }
        });
        return mm;
    }

}


