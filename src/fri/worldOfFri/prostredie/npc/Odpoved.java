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
public class Odpoved {

    private final String odpoved;
    private final VrcholRozhovoru dalsiVrchol;

    public Odpoved(String odpoved, VrcholRozhovoru dalsiVrchol) {
        this.odpoved = odpoved;
        this.dalsiVrchol = dalsiVrchol;
    }

    public String getOdpoved() {
        return this.odpoved;
    }

    public VrcholRozhovoru getDalsiVrchol() {
        return this.dalsiVrchol;
    }
    
}
