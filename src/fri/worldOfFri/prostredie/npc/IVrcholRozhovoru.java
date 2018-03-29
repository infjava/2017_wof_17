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
public interface IVrcholRozhovoru {

    boolean jeKoniec();
    void vypis();
    IVrcholRozhovoru getDalsi(char znak);
    
}
