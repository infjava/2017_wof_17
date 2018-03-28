/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.npc;

/**
 *
 * @author janik
 */
public class Npc {
    private final String meno;

    public Npc(String meno, VrcholRozhovoru zaciatokRozhovoru) {
        this.meno = meno;
    }

    public String getMeno() {
        return this.meno;
    }

    public void hovor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
