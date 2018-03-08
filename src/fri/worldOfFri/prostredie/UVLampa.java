/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import fri.worldOfFri.hra.Hrac;


public class UVLampa implements IPredmet {

    @Override
    public String getNazov() {
        return "uvlampa";
    }

    @Override
    public void pouziSa(Hrac hrac) {
        if (!hrac.getAktualnaMiestnost().getNazov().equals("sklad")) {
            System.out.println("Nic si nenasiel");
            return;
        }
        
        hrac.getAktualnaMiestnost().vlozPredmet(new VseobecnyPredmet("vzorka"));
        
        System.out.println("Objavili sa vzorky dna");
    }

    @Override
    public boolean daSaPolozit() {
        return true;
    }
    
}
