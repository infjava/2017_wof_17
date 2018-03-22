/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.dvere;

import fri.worldOfFri.prostredie.Miestnost;
import java.util.Arrays;


public class SekerouOdomykatelneDvere implements IDvere {
    private final Miestnost miestnostA;
    private final Miestnost miestnostB;
    private boolean zamknute;

    public SekerouOdomykatelneDvere(Miestnost miestnostA, Miestnost miestnostB) {
        this.miestnostA = miestnostA;
        this.miestnostB = miestnostB;
        this.zamknute = true;
    }

    @Override
    public Miestnost getCiel(Miestnost odkial) {
        if (this.zamknute) {
            return null;
        } else if (odkial == this.miestnostA) {
            return this.miestnostB;
        } else if (odkial == this.miestnostB) {
            return this.miestnostA;
        } else {
            return null;
        }
    }

    @Override
    public String getNazov(Miestnost odkial) {
        return "zamknute";
    }
    
    public void odomkni() {
        this.zamknute = false;
    }

    @Override
    public Iterable<Miestnost> getVsetkyMozneVychody(Miestnost odkial) {
        if (odkial == this.miestnostA) {
            return Arrays.asList(this.miestnostB);
        } else if (odkial == this.miestnostB) {
            return Arrays.asList(this.miestnostA);
        } else {
            return Arrays.asList();
        }
    }
}