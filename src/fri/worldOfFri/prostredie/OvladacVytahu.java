/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import fri.worldOfFri.hra.Hrac;

/**
 *
 * @author janik
 */
public class OvladacVytahu implements IPredmet {

    @Override
    public String getNazov() {
        return "ovladac";
    }

    @Override
    public void pouziSa(Hrac hrac) {
        final Miestnost aktualnaMiestnost = hrac.getAktualnaMiestnost();
        
        for (String vychod : aktualnaMiestnost.getVychody()) {
            final IDvere dvere = aktualnaMiestnost.getDvere(vychod);
            
            if (dvere instanceof VytahoveDvere) {
                ((VytahoveDvere)dvere).posunVytah();
                return;
            }
        }
        
        System.out.println("Nie si vo vytahu!");
    }

    @Override
    public boolean daSaPolozit() {
        return true;
    }
}
