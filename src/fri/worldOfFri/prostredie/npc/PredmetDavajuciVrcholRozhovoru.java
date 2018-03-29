/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.npc;

import fri.worldOfFri.hra.Hrac;
import fri.worldOfFri.prostredie.predmety.IPredmet;


public class PredmetDavajuciVrcholRozhovoru implements IVrcholRozhovoru {

    private final String hlaska;
    private IPredmet davanyPredmet;

    public PredmetDavajuciVrcholRozhovoru(String hlaska, IPredmet davanyPredmet) {
        this.hlaska = hlaska;
        this.davanyPredmet = davanyPredmet;
    }

    @Override
    public boolean jeKoniec() {
        return true;
    }

    @Override
    public void vypis() {
        if (this.davanyPredmet != null) {
            System.out.println(this.hlaska);
        } else {
            System.out.println("Sorry!");
        }
    }

    @Override
    public IVrcholRozhovoru getDalsi(char znak) {
        return null;
    }

    @Override
    public void akcia(Hrac hrac) {
        if (this.davanyPredmet != null) {
            hrac.vlozPredmet(this.davanyPredmet);
            this.davanyPredmet = null;
        }
    }
    
}
