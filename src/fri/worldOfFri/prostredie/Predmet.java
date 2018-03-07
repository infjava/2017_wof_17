/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import java.util.Random;

/**
 *
 * @author janik
 */
public class Predmet {

    private final String nazov;

    public Predmet(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void pouziSa() {
        Random r = new Random();
        
        if (r.nextInt(100) < 20) {
            System.out.println("Je mi to veeelmi luto, ale si mrtvy!");
            System.exit(0);
        }
    }
}
