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
import fri.worldOfFri.vynimky.DvereNepriechodneException;
import fri.worldOfFri.vynimky.SmrtException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sekera implements IPredmet {

    @Override
    public String getNazov() {
        return "sekera";
    }

    @Override
    public void pouziSa(Hrac hrac)
            throws SmrtException {
        Random r = new Random();

        if (r.nextInt(100) < 20) {
            System.out.println("Je mi to veeelmi luto, ale si mrtvy!");
            throw new SmrtException();
        }
        
        final Miestnost aktualnaMiestnost = hrac.getAktualnaMiestnost();
        
        for (String vychod : aktualnaMiestnost.getVychody()) {
            final IDvere dvere = aktualnaMiestnost.getDvere(vychod);
            
            if (dvere instanceof SekerouOdomykatelneDvere) {
                ((SekerouOdomykatelneDvere)dvere).odomkni();
                
                try {
                    System.out.println("Odomkol si dvere do miestnosti "
                            + dvere.getCiel(aktualnaMiestnost).getNazov());
                } catch (DvereNepriechodneException ex) {
                    
                }
            }
        }
    }

    @Override
    public boolean daSaPolozit() {
        return true;
    }

}
