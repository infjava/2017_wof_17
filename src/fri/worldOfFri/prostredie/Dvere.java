/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

/**
 *
 * @author janik
 */
class Dvere {
    private final Miestnost miestnostA;
    private final Miestnost miestnostB;

    Dvere(Miestnost miestnostA, Miestnost miestnostB) {
        this.miestnostA = miestnostA;
        this.miestnostB = miestnostB;
    }
    
    Miestnost getCiel(Miestnost odkial) {
        if (odkial == this.miestnostA) {
            return this.miestnostB;
        } else if (odkial == this.miestnostB) {
            return this.miestnostA;
        } else {
            return null;
        }
    }
}
