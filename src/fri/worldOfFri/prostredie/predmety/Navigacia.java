/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.predmety;

import fri.worldOfFri.prostredie.dvere.IDvere;
import fri.worldOfFri.hra.Hrac;
import fri.worldOfFri.prikazy.Parser;
import fri.worldOfFri.prostredie.Mapa;
import fri.worldOfFri.prostredie.Miestnost;

/**
 *
 * @author janik
 */
public class Navigacia implements IPredmet {

    private final Mapa mapa;

    public Navigacia(Mapa mapa) {
        this.mapa = mapa;
    }

    @Override
    public String getNazov() {
        return "navigacia";
    }

    @Override
    public void pouziSa(Hrac hrac) {
        String nazovCielu = Parser.getInstancia().nacitajString("Zadaj cielovu miestnost:");
        Miestnost ciel = this.mapa.getMiestnost(nazovCielu);
        
        if (ciel == null) {
            System.out.println("Neznama miestnost");
            return;
        }
        
        final Iterable<Miestnost> cesta = this.mapa.getCesta(hrac.getAktualnaMiestnost(), ciel);
        
        if (cesta == null) {
            System.out.println("Neda sa najst cesta!");
            return;
        }
        
        Miestnost predchadzajuca = null;
        System.out.println("Cesta:");
        for (Miestnost miestnost : cesta) {
            final String nazovMiestnosti = miestnost.getNazov();
            
            if (predchadzajuca == null) {
                System.out.println("- " + nazovMiestnosti);
            } else {
                final IDvere dvereDo = predchadzajuca.getDvereDo(miestnost);
                final String nazovDveriDo = dvereDo.getNazov(predchadzajuca);
                if (nazovDveriDo.equals(nazovMiestnosti)) {
                    System.out.println("- " + nazovMiestnosti);
                } else {
                    System.out.println("- " + nazovDveriDo + " => " + nazovMiestnosti);
                }
            }
            predchadzajuca = miestnost;
        }
    }

    @Override
    public boolean daSaPolozit() {
        return true;
    }
    
}
