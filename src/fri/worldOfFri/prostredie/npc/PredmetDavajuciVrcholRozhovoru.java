/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.npc;


public class PredmetDavajuciVrcholRozhovoru implements IVrcholRozhovoru {

    private final String hlaska;

    public PredmetDavajuciVrcholRozhovoru(String hlaska) {
        this.hlaska = hlaska;
    }

    @Override
    public boolean jeKoniec() {
        return true;
    }

    @Override
    public void vypis() {
        System.out.println(this.hlaska);
    }

    @Override
    public IVrcholRozhovoru getDalsi(char znak) {
        return null;
    }
    
}
