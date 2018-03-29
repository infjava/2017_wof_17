/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.npc;

import fri.worldOfFri.hra.Hrac;
import java.util.Scanner;

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
        Scanner vstup = new Scanner(System.in);
        
        IVrcholRozhovoru dalsi = this.zaciatokRozhovoru;
        while (!dalsi.jeKoniec()) {            
            dalsi.vypis();
            dalsi.akcia(hrac);
            
            System.out.print("> ");
            char znak = vstup.nextLine().charAt(0);
            
            dalsi = dalsi.getDalsi(znak);
        }
        dalsi.vypis();
        dalsi.akcia(hrac);
    }
}
