/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.npc;

import fri.worldOfFri.hra.Hrac;
import fri.worldOfFri.prikazy.Parser;

/**
 *
 * @author janik
 */
public class Npc {
    private final String meno;
    private final IVrcholRozhovoru zaciatokRozhovoru;

    public Npc(String meno, IVrcholRozhovoru zaciatokRozhovoru) {
        this.meno = meno;
        this.zaciatokRozhovoru = zaciatokRozhovoru;
    }

    public String getMeno() {
        return this.meno;
    }

    public void hovor(Hrac hrac) {
        IVrcholRozhovoru dalsi = this.zaciatokRozhovoru;
        while (!dalsi.jeKoniec()) {            
            dalsi.vypis();
            dalsi.akcia(hrac);
            
            char znak = Parser.getInstancia().nacitajString(">").charAt(0);
            
            dalsi = dalsi.getDalsi(znak);
        }
        dalsi.vypis();
        dalsi.akcia(hrac);
    }
}
