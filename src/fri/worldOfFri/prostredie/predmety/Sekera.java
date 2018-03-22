/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.predmety;

import fri.worldOfFri.prostredie.dvere.IDvere;
import fri.worldOfFri.prostredie.dvere.SekerouOdomykatelneDvere;
import fri.worldOfFri.hra.Hrac;
import fri.worldOfFri.prostredie.Miestnost;
import java.util.Random;

public class Sekera implements IPredmet {

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
        
        final Miestnost aktualnaMiestnost = hrac.getAktualnaMiestnost();
        
        for (String vychod : aktualnaMiestnost.getVychody()) {
            final IDvere dvere = aktualnaMiestnost.getDvere(vychod);
            
            if (dvere instanceof SekerouOdomykatelneDvere) {
                ((SekerouOdomykatelneDvere)dvere).odomkni();
                
                System.out.println("Odomkol si dvere do miestnosti "
                        + dvere.getCiel(aktualnaMiestnost).getNazov());
            }
        }
    }

    @Override
    public boolean daSaPolozit() {
        return true;
    }

}
