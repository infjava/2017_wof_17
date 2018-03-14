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
class VseobecnyPredmet implements IPredmet {

    private final String nazov;

    VseobecnyPredmet(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void pouziSa(Hrac hrac) {
        System.out.println("Neda sa");
    }

    @Override
    public boolean daSaPolozit() {
        return true;
    }
}
