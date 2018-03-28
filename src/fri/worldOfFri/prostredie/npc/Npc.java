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
    private final VrcholRozhovoru zaciatokRozhovoru;

    public Npc(String meno, VrcholRozhovoru zaciatokRozhovoru) {
        this.meno = meno;
        this.zaciatokRozhovoru = zaciatokRozhovoru;
    }

    public String getMeno() {
        return this.meno;
    }

    public void hovor() {
        this.zaciatokRozhovoru.vypis();
    }
}
