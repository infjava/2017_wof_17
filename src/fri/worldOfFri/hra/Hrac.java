/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.hra;

import fri.worldOfFri.prostredie.predmety.IPredmet;
import fri.worldOfFri.prostredie.Mapa;
import fri.worldOfFri.prostredie.Miestnost;
import fri.worldOfFri.prostredie.npc.Npc;
import java.util.HashMap;

/**
 *
 * @author janik
 */
public class Hrac {

    private Miestnost aktualnaMiestnost;
    private final HashMap<String, IPredmet> inventar;

    Hrac(Mapa mapa) {
        this.aktualnaMiestnost = mapa.getStartovaciaMiestnost();
        this.inventar = new HashMap<String, IPredmet>();
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    boolean chod(String smer) {
        Miestnost nova = this.aktualnaMiestnost.getVychod(smer);
        
        if (nova == null) {
            return false;
        }
        
        this.aktualnaMiestnost = nova;
        return true;
    }

    boolean zdvihniPredmet(String nazovPredmetu) {
        IPredmet zdvihany = this.aktualnaMiestnost.odstranPredmet(nazovPredmetu);
        
        if (zdvihany == null) {
            return false;
        }
        
        this.inventar.put(nazovPredmetu, zdvihany);
        return true;
    }

    void vypisStaty() {
        if (!this.inventar.isEmpty()) {
            System.out.println("Predmety v inventari:");
            
            for (String nazovPredmetu : this.inventar.keySet()) {
                System.out.println("- " + nazovPredmetu);
            }
        } else {
            System.out.println("Inventar mas prazdny!");
        }
    }

    boolean polozPredmet(String nazovPredmetu) {
        IPredmet pokladany = this.inventar.get(nazovPredmetu);
        
        if (pokladany == null) {
            return false;
        }
        
        if (!pokladany.daSaPolozit()) {
            return false;
        }
        
        this.inventar.remove(nazovPredmetu);
        this.aktualnaMiestnost.vlozPredmet(pokladany);
        return true;
    }

    void pouziPredmet(String nazovPredmetu) {
        IPredmet pouzivany = this.inventar.get(nazovPredmetu);
        
        if (pouzivany == null) {
            return;
        }
        
        pouzivany.pouziSa(this);
    }

    void hovorSNpc(String meno) {
        Npc npc = this.getAktualnaMiestnost().getNpc(meno);
        
        if (npc == null) {
            return;
        }
        
        npc.hovor();
    }
}
