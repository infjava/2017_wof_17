/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.dvere;

import fri.worldOfFri.prostredie.Miestnost;
import java.util.Arrays;

/**
 *
 * @author janik
 */
public class VytahoveDvere implements IDvere {

    private final Miestnost vytah;
    private final Miestnost[] vychody;
    private int pozicia;
    private int smer;

    public VytahoveDvere(Miestnost vytah, Miestnost[] vychody) {
        this.vytah = vytah;
        this.vychody = vychody;
        this.pozicia = 0;
        this.smer = 1;
    }

    @Override
    public Miestnost getCiel(Miestnost odkial) {
        if (odkial == this.vytah) {
            return this.vychody[this.pozicia];
        } else if (this.vychody[this.pozicia] == odkial) {
            return this.vytah;
        } else {
            return null;
        }
    }

    @Override
    public String getNazov(Miestnost odkial) {
        if (odkial == this.vytah) {
            return "von";
        } else {
            return "vytah";
        }
    }
    
    public void posunVytah() {
        int ocakavanaPozicia = this.pozicia + this.smer;
        
        if (ocakavanaPozicia < 0 || ocakavanaPozicia >= this.vychody.length) {
            this.smer = -this.smer;
        }
        
        this.pozicia += this.smer;
        
        System.out.println("Vytah sa pohol na " + this.getCiel(this.vytah).getNazov());
    }

    @Override
    public Iterable<Miestnost> getVsetkyMozneVychody(Miestnost odkial) {
        if (odkial == this.vytah) {
            return Arrays.asList(this.vychody);
        } else if (this.vychody[this.pozicia] == odkial) {
            return Arrays.asList(this.vytah);
        } else {
            return Arrays.asList();
        }
    }
}
