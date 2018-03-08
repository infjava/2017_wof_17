/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import fri.worldOfFri.hra.Hrac;
import java.util.Random;

class Sekera implements IPredmet {

    @Override
    public String getNazov() {
        return "sekera";
    }

    @Override
    public void pouziSa(Hrac hrac) {
        Random r = new Random();

        if (r.nextInt(100) < 20) {
            System.out.println("Je mi to veeelmi luto, ale si mrtvy!");
            System.exit(0);
        }
    }

    @Override
    public boolean daSaPolozit() {
        return true;
    }

}
