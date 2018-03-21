/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import java.util.Arrays;

/**
 *
 * @author janik
 */
class Dvere implements IDvere {
    private final Miestnost miestnostA;
    private final Miestnost miestnostB;

    Dvere(Miestnost miestnostA, Miestnost miestnostB) {
        this.miestnostA = miestnostA;
        this.miestnostB = miestnostB;
    }
    
    @Override
    public Miestnost getCiel(Miestnost odkial) {
        if (odkial == this.miestnostA) {
            return this.miestnostB;
        } else if (odkial == this.miestnostB) {
            return this.miestnostA;
        } else {
            return null;
        }
    }

    @Override
    public String getNazov(Miestnost odkial) {
        return this.getCiel(odkial).getNazov();
    }

    @Override
    public Iterable<Miestnost> getVsetkyMozneVychody(Miestnost odkial) {
        final Miestnost ciel = this.getCiel(odkial);
        
        if (ciel == null) {
            return Arrays.asList();
        }
        
        return Arrays.asList(ciel);
    }
}
