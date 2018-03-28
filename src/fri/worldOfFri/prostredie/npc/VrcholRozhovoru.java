/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.npc;

import java.util.ArrayList;

/**
 *
 * @author janik
 */
public class VrcholRozhovoru {

    private final ArrayList<String> odpovede;

    public VrcholRozhovoru() {
        this.odpovede = new ArrayList<String>();
    }

    public VrcholRozhovoru(String hlaska) {
        this.odpovede = new ArrayList<String>();
    }

    public void pridajOdpoved(String odpoved, VrcholRozhovoru dalsiVrchol) {
        this.odpovede.add(odpoved);
    }

    void vypis() {
        char znakOdpovede = 'A';
        for (String odpoved : this.odpovede) {
            System.out.format("%c) %s%n", znakOdpovede, odpoved);
            //System.out.println(znakOdpovede + ")" + odpoved);
            znakOdpovede++;
        }
    }
    
}
