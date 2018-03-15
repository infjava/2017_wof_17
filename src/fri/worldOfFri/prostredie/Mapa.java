/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import java.util.ArrayList;

/**
 *
 * @author janik
 */
public class Mapa {

    private final Miestnost startovaciaMiestnost;
    private final ArrayList<Miestnost> zoznamMiestnosti;

    public Mapa() {
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
        
        this.vytvorDvere(terasa, vratnica);
        this.vytvorDvere(terasa, aula);
        
        terasa.vlozPredmet(new Sekera());
        terasa.vlozPredmet(new Navleky());
        terasa.vlozPredmet(new PredmetMapa(this));
        
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
}
