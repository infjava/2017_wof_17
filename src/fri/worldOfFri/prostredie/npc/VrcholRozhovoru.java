/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.npc;

import fri.worldOfFri.hra.Hrac;
import java.util.ArrayList;

/**
 *
 * @author janik
 */
public class VrcholRozhovoru implements IVrcholRozhovoru {

    private final ArrayList<Odpoved> odpovede;
    private final String hlaska;

    public VrcholRozhovoru() {
        this(null);
    }

    public VrcholRozhovoru(String hlaska) {
        this.odpovede = new ArrayList<Odpoved>();
        this.hlaska = hlaska;
    }

    public void pridajOdpoved(String odpoved, IVrcholRozhovoru dalsiVrchol) {
        this.odpovede.add(new Odpoved(odpoved, dalsiVrchol));
    }

    @Override
    public void vypis() {
        if (this.hlaska != null) {
            System.out.println(this.hlaska);
        }
        
        char znakOdpovede = 'A';
        for (Odpoved odpoved : this.odpovede) {
            System.out.format("%c) %s%n", znakOdpovede, odpoved.getOdpoved());
            //System.out.println(znakOdpovede + ")" + odpoved);
            znakOdpovede++;
        }
    }

    @Override
    public IVrcholRozhovoru getDalsi(char znak) {
        int index = znak - 'A';
        
        return this.odpovede.get(index).getDalsiVrchol();
    }

    @Override
    public boolean jeKoniec() {
        return this.odpovede.isEmpty();
    }

    @Override
    public void akcia(Hrac hrac) {
        
    }
}
