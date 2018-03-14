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
        
        this.zoznamMiestnosti.add(terasa);
        this.zoznamMiestnosti.add(vratnica);
        this.zoznamMiestnosti.add(ra);
        this.zoznamMiestnosti.add(wc);
        this.zoznamMiestnosti.add(ra13);
        this.zoznamMiestnosti.add(bufet);
        this.zoznamMiestnosti.add(aula);
        this.zoznamMiestnosti.add(rb);
        this.zoznamMiestnosti.add(sklad);
        
        terasa.nastavVychod(vratnica);
        terasa.nastavVychod(aula);
        
        terasa.vlozPredmet(new Sekera());
        terasa.vlozPredmet(new Navleky());
        terasa.vlozPredmet(new PredmetMapa(this));
        
        vratnica.nastavVychod(terasa);
        vratnica.nastavVychod(ra);
        vratnica.nastavVychod(rb);
        
        ra.nastavVychod(vratnica);
        ra.nastavVychod(wc);
        ra.nastavVychod(ra13);
        ra.nastavVychod(bufet);
        ra.nastavVychod(aula);
        
        wc.nastavVychod(ra);
        
        ra13.nastavVychod(ra);
        
        bufet.nastavVychod(ra);
        bufet.nastavVychod(aula);
        
        aula.nastavVychod(terasa);
        aula.nastavVychod(ra);
        aula.nastavVychod(bufet);
        
        rb.nastavVychod(vratnica);
        rb.nastavVychod(sklad);
        
        sklad.nastavVychod(rb);

        this.startovaciaMiestnost = terasa;  // startovacia miestnost hry
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }

    public Iterable<Miestnost> getZoznamMiestnosti() {
        return this.zoznamMiestnosti;
    }
}
