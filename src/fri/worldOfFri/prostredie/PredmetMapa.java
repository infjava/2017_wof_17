/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import fri.worldOfFri.hra.Hrac;

/**
 *
 * @author janik
 */
public class PredmetMapa implements IPredmet {

    private final Mapa mapa;

    PredmetMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    @Override
    public String getNazov() {
        return "mapa";
    }

    @Override
    public void pouziSa(Hrac hrac) {
        for (Miestnost miestnost : this.mapa.getZoznamMiestnosti()) {
            System.out.println("* " + miestnost.getNazov());
            
            for (String vychod : miestnost.getVychody()) {
                System.out.println("  - " + vychod);
            }
        }
    }

    @Override
    public boolean daSaPolozit() {
        return true;
    }
}
