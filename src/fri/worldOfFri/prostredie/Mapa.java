/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import fri.worldOfFri.prostredie.predmety.Navleky;
import fri.worldOfFri.prostredie.predmety.Navigacia;
import fri.worldOfFri.prostredie.predmety.Sekera;
import fri.worldOfFri.prostredie.predmety.OvladacVytahu;
import fri.worldOfFri.prostredie.predmety.PredmetMapa;
import fri.worldOfFri.prostredie.dvere.IDvere;
import fri.worldOfFri.prostredie.dvere.VytahoveDvere;
import fri.worldOfFri.prostredie.dvere.Dvere;
import fri.worldOfFri.prostredie.dvere.SekerouOdomykatelneDvere;
import fri.worldOfFri.prostredie.npc.Npc;
import fri.worldOfFri.prostredie.npc.PredmetDavajuciVrcholRozhovoru;
import fri.worldOfFri.prostredie.npc.VrcholRozhovoru;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author janik
 */
public class Mapa {

    private Miestnost startovaciaMiestnost;
    private final ArrayList<Miestnost> zoznamMiestnosti;

    public Mapa() {
        this.startovaciaMiestnost = null;
        this.zoznamMiestnosti = new ArrayList<Miestnost>();
        
        File suborSMapou = new File("mapa.txt");
        try (Scanner citacMapy = new Scanner(suborSMapou)) {
            while (citacMapy.hasNextLine()) {
                String riadok = citacMapy.nextLine();
                
                if (riadok.trim().isEmpty()) {
                    continue;
                }
                
                // zacina odsadenim?
                if (riadok.startsWith(" ")) {
                    // toto este doplnime
                } else {
                    //String[] slova = riadok.split(" ");
                    Scanner slova = new Scanner(riadok);
                    String prikaz = slova.next();
                    String parameter = slova.next();
                    
                    switch (prikaz) {
                        case "miestnost":
                            this.nacitajMiestnost(parameter, citacMapy);
                            break;
                        case "npc":
                            this.nacitajNpc(parameter, citacMapy);
                            break;
                        case "start":
                            this.nacitajStart(parameter, citacMapy);
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Nepodarilo sa nacitat mapu", ex);
        }
        
        /*
        this.zoznamMiestnosti = new ArrayList<Miestnost>();
        
        // vytvorenie miestnosti
        Miestnost terasa = new Miestnost("terasa", "prave tu prebieha FRIfest");
        Miestnost vratnica = new Miestnost("vratnica", "vchod na fakultu");
        Miestnost ra = new Miestnost("ra", "dolezitejsia chodba na fakulte");
        Miestnost wc = new Miestnost("wc", "niekto tu momentalne faxuje");
        Miestnost ra13 = new Miestnost("ra13", "pocitacovy labak");
        Miestnost bufet = new Miestnost("bufet", "citim tu vonu... horaliek");
        Miestnost aula = new Miestnost("aula", "tu chod opatrne, potichucku, aby nepadla strecha");
        Miestnost rb = new Miestnost("rb", "temna chodba");
        Miestnost sklad = new Miestnost("sklad", "sklad vrazednych zbrani");
        
        Miestnost vytah = new Miestnost("vytah", "vozi hore-dole");
        Miestnost ra1 = new Miestnost("ra1", "ra na prvom poschodi");
        Miestnost ra2 = new Miestnost("ra2", "ra na druhom poschodi");
        Miestnost ra3 = new Miestnost("ra3", "ra na tretom poschodi");
        
        this.zoznamMiestnosti.add(terasa);
        this.zoznamMiestnosti.add(vratnica);
        this.zoznamMiestnosti.add(ra);
        this.zoznamMiestnosti.add(wc);
        this.zoznamMiestnosti.add(ra13);
        this.zoznamMiestnosti.add(bufet);
        this.zoznamMiestnosti.add(aula);
        this.zoznamMiestnosti.add(rb);
        this.zoznamMiestnosti.add(sklad);
        this.zoznamMiestnosti.add(vytah);
        this.zoznamMiestnosti.add(ra1);
        this.zoznamMiestnosti.add(ra2);
        this.zoznamMiestnosti.add(ra3);
        
        this.vytvorDvere(terasa, vratnica);
        this.vytvorDvere(terasa, aula);
        
        terasa.vlozPredmet(new Sekera());
        //terasa.vlozPredmet(new Navleky());
        terasa.vlozPredmet(new PredmetMapa(this));
        terasa.vlozPredmet(new Navigacia(this));
        
        VrcholRozhovoru ucitelZaciatok = new VrcholRozhovoru();
        VrcholRozhovoru ucitelPozdravenie = new VrcholRozhovoru("dobry den\nco potrebujete?");
        VrcholRozhovoru ucitelNie = new VrcholRozhovoru("nie!");
        PredmetDavajuciVrcholRozhovoru ucitelDaNavleky = new PredmetDavajuciVrcholRozhovoru(
                "nech sa paci",
                new Navleky()
        );
        VrcholRozhovoru ucitelZjePizzu = new VrcholRozhovoru("chrum chrum chrum... uz nie");
        
        ucitelZaciatok.pridajOdpoved("dobry den", ucitelPozdravenie);
        ucitelZaciatok.pridajOdpoved("nemate navleky?", ucitelNie);
        
        ucitelPozdravenie.pridajOdpoved("nemate navleky?", ucitelDaNavleky);
        ucitelPozdravenie.pridajOdpoved("nemate pizzu?", ucitelZjePizzu);
        
        ucitelZjePizzu.pridajOdpoved("nemate pizzu?", ucitelDaNavleky);
        
        terasa.postavNpc(new Npc("ucitel", ucitelZaciatok));
        
        this.vytvorDvere(vratnica, ra);
        this.vytvorDvere(vratnica, rb);
        
        this.vytvorDvere(ra, wc, new SekerouOdomykatelneDvere(ra, wc));
        this.vytvorDvere(ra, ra13);
        this.vytvorDvere(ra, bufet);
        this.vytvorDvere(ra, aula);
        
        VytahoveDvere vytahDvere = new VytahoveDvere(vytah, new Miestnost[] {ra, ra1, ra2, ra3});
        
        vytah.nastavVychod(vytahDvere);
        ra.nastavVychod(vytahDvere);
        ra1.nastavVychod(vytahDvere);
        ra2.nastavVychod(vytahDvere);
        ra3.nastavVychod(vytahDvere);
        
        vytah.vlozPredmet(new OvladacVytahu());
        
        this.vytvorDvere(bufet, aula);
        
        this.vytvorDvere(rb, sklad);

        this.startovaciaMiestnost = terasa;  // startovacia miestnost hry
        */
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }

    public Iterable<Miestnost> getZoznamMiestnosti() {
        return this.zoznamMiestnosti;
    }

    private void vytvorDvere(Miestnost miestnostZ, Miestnost miestnostDo) {
        this.vytvorDvere(miestnostZ, miestnostDo, new Dvere(miestnostZ, miestnostDo));
    }

    private void vytvorDvere(Miestnost miestnostZ, Miestnost miestnostDo, IDvere dvere) {
        miestnostZ.nastavVychod(dvere);
        miestnostDo.nastavVychod(dvere);
    }

    public Miestnost getMiestnost(String nazovCielu) {
        for (Miestnost miestnost : this.zoznamMiestnosti) {
            if (miestnost.getNazov().equals(nazovCielu)) {
                return miestnost;
            }
        }
        
        return null;
    }

    public Iterable<Miestnost> getCesta(Miestnost vychod, Miestnost ciel) {
        int cisloVychod = this.getCisloMiestnosti(vychod);
        int cisloCiel = this.getCisloMiestnosti(ciel);
        
        int[][] maticaVzdialenosti = new int[this.getPocetMiestnosti()][this.getPocetMiestnosti()];
        int[][] maticaPrechodov = new int[this.getPocetMiestnosti()][this.getPocetMiestnosti()];
        
        this.inicializujFloyda(maticaVzdialenosti, maticaPrechodov);
        this.vypocitajFloyda(maticaVzdialenosti, maticaPrechodov);
        return this.najdiFloyda(maticaPrechodov, cisloVychod, cisloCiel);
    }
    
    private int getPocetMiestnosti() {
        return this.zoznamMiestnosti.size();
    }

    private int getCisloMiestnosti(Miestnost miestnost) {
        return this.zoznamMiestnosti.indexOf(miestnost);
    }

    private void inicializujFloyda(int[][] maticaVzdialenosti, int[][] maticaPrechodov) {
        for (int y = 0; y < this.getPocetMiestnosti(); y++) {
            for (int x = 0; x < this.getPocetMiestnosti(); x++) {
                maticaPrechodov[y][x] = -1;
                // 1000000 je nekonecno.
                // Nemoze byt Integer.MAX_VALUE, lebo sa budu scitavat
                maticaVzdialenosti[y][x] = 1000000;
            }
        }
        
        
        for (Miestnost vychodzia : this.zoznamMiestnosti) {
            int vychodziaCislo = this.getCisloMiestnosti(vychodzia);
            for (Miestnost cielova : vychodzia.getCieloveMiestnosti()) {
                int cielovaCislo = this.getCisloMiestnosti(cielova);
                
                maticaVzdialenosti[vychodziaCislo][cielovaCislo] = 1;
                maticaPrechodov[vychodziaCislo][cielovaCislo] = vychodziaCislo;
            }
        }
    }

    private void vypocitajFloyda(int[][] maticaVzdialenosti, int[][] maticaPrechodov) {
        for (int vychodzia = 0; vychodzia < this.getPocetMiestnosti(); vychodzia++) {
            for (int cielova = 0; cielova < this.getPocetMiestnosti(); cielova++) {
                for (int prechodova = 0; prechodova < this.getPocetMiestnosti(); prechodova++) {
                    int staraVzdialenost = maticaVzdialenosti[vychodzia][cielova];
                    int novaVzdialenost = maticaVzdialenosti[vychodzia][prechodova]
                            + maticaVzdialenosti[prechodova][cielova];
                    
                    if (novaVzdialenost < staraVzdialenost) {
                        maticaVzdialenosti[vychodzia][cielova] = novaVzdialenost;
                        maticaPrechodov[vychodzia][cielova] = prechodova;
                    }
                }
            }
        }
    }

    private Iterable<Miestnost> najdiFloyda(int[][] maticaPrechodov, int cisloVychod, int cisloCiel) {
        ArrayList<Miestnost> ret = new ArrayList<Miestnost>();
        
        int cisloAktualna = cisloCiel;
        
        while (cisloAktualna != cisloVychod) {
            ret.add(0, this.zoznamMiestnosti.get(cisloAktualna));
            cisloAktualna = maticaPrechodov[cisloVychod][cisloAktualna];
            
            if (cisloAktualna == -1) {
                return null;
            }
        }
        
        ret.add(0, this.zoznamMiestnosti.get(cisloVychod));
        
        return ret;
    }

    private void nacitajMiestnost(String nazovMiestnosti, Scanner citacMapy) {
        String riadokPopisu;
        //String popisMiestnosti = "";
        StringBuilder popisMiestnosti = new StringBuilder();
        do {
            riadokPopisu = citacMapy.nextLine().trim();
            //popisMiestnosti += riadokPopisu + '\n';
            popisMiestnosti.append(riadokPopisu);
            popisMiestnosti.append('\n');
        } while (!riadokPopisu.isEmpty());
        
        Miestnost nacitana = new Miestnost(nazovMiestnosti, popisMiestnosti.toString().trim());
        this.zoznamMiestnosti.add(nacitana);
    }

    private void nacitajNpc(String parameter, Scanner citacMapy) {
        
    }

    private void nacitajStart(String nazovMiestnosti, Scanner citacMapy) {
        this.startovaciaMiestnost = this.getMiestnost(nazovMiestnosti);
    }
}
