/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.npc;

import java.util.Scanner;

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
        
        Scanner vstup = new Scanner(System.in);
        
        System.out.print("> ");
        char znak = vstup.nextLine().charAt(0);
        
        VrcholRozhovoru dalsi = this.zaciatokRozhovoru.getDalsi(znak);
        dalsi.vypis();
    }
}
