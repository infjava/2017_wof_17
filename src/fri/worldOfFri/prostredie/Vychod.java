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
class Vychod {

    private final Miestnost miestnostZ;
    private final String[] miestnostiDo;
    private final String nazovTriedy;

    Vychod(Miestnost miestnostZ, String[] miestnostiDo, String nazovTriedy) {
        this.miestnostZ = miestnostZ;
        this.miestnostiDo = miestnostiDo;
        this.nazovTriedy = nazovTriedy;
    }

    public Miestnost getMiestnostZ() {
        return this.miestnostZ;
    }

    public String[] getMiestnostiDo() {
        return this.miestnostiDo;
    }

    public String getNazovTriedy() {
        return this.nazovTriedy;
    }
    
}
