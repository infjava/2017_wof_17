package fri.worldOfFri.prostredie;


import fri.worldOfFri.prostredie.predmety.IPredmet;
import fri.worldOfFri.prostredie.dvere.IDvere;
import fri.worldOfFri.prostredie.npc.Npc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Trieda Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {
    private final String popisMiestnosti;
    private final HashMap<String, IDvere> vychody;
    private final String nazov;
    private final HashMap<String, IPredmet> zoznamPredmetov;
    private final HashMap<String, Npc> zoznamNpc;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String nazov, String popis) {
        this.vychody = new HashMap<String, IDvere>();
        this.popisMiestnosti = popis;
        this.nazov = nazov;
        this.zoznamPredmetov = new HashMap<String, IPredmet>();
        this.zoznamNpc = new HashMap<String, Npc>();
    }

    public String getNazov() {
        return this.nazov;
    }

    /**
     * Nastavi vychody z miestnosti. Kazdy vychod je urceny bud odkazom 
     * na miestnost alebo hodnotou null, ak vychod tym smerom neexistuje.
     * 
     * @param nazov nazov smeru.
     * @param vychod miestnost danym smerom .
     */
    public void nastavVychod(IDvere vychod) {
        this.vychody.put(vychod.getNazov(this), vychod);
    }

    public Miestnost getVychod(String smer) {
        final IDvere ciel = this.vychody.get(smer);
        
        if (ciel == null) {
            return null;
        }
        
        return ciel.getCiel(this);
    }

    public void vypisInfo() {
        System.out.println(this.nazov);
        System.out.println(this.popisMiestnosti);
        
        this.vypisZoznam("Vychody", this.vychody.keySet());
        this.vypisZoznam("Predmety", this.zoznamPredmetov.keySet());
        this.vypisZoznam("Npc", this.zoznamNpc.keySet());
    }

    private void vypisZoznam(String nazov, Set<String> zoznam) {
        if (!zoznam.isEmpty()) {
            System.out.print(nazov + ": ");
            
            for (String nazovPolozky : zoznam) {
                System.out.print(nazovPolozky + " ");
            }
            
            System.out.println();
        }
    }

    public void vlozPredmet(IPredmet predmet) {
        this.zoznamPredmetov.put(predmet.getNazov(), predmet);
    }

    public IPredmet odstranPredmet(String nazovPredmetu) {
        return this.zoznamPredmetov.remove(nazovPredmetu);
    }
    
    public Iterable<String> getVychody() {
        return this.vychody.keySet();
    }

    public IDvere getDvere(String smer) {
        return this.vychody.get(smer);
    }

    Iterable<Miestnost> getCieloveMiestnosti() {
        ArrayList<Miestnost> cieloveMiestnosti = new ArrayList<Miestnost>();
        
        for (IDvere dvere : this.vychody.values()) {
            for (Miestnost miestnost : dvere.getVsetkyMozneVychody(this)) {
                cieloveMiestnosti.add(miestnost);
            }
        }
        
        return cieloveMiestnosti;
    }

    public IDvere getDvereDo(Miestnost miestnost) {
        for (IDvere dvere : this.vychody.values()) {
            for (Miestnost miestnostDveri : dvere.getVsetkyMozneVychody(this)) {
                if (miestnost == miestnostDveri) {
                    return dvere;
                }
            }
        }
        
        return null;
    }

    void postavNpc(Npc npc) {
        this.zoznamNpc.put(npc.getMeno(), npc);
    }
}
