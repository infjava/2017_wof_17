/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import fri.worldOfFri.hra.Hrac;


class Navleky implements IPredmet {
    private boolean obute;

    Navleky() {
        this.obute = false;
    }

    @Override
    public String getNazov() {
        return "navleky";
    }

    @Override
    public void pouziSa(Hrac hrac) {
        this.obute = !this.obute;

        if (this.obute) {
            System.out.println("Obul si si navleky");
        } else {
            System.out.println("Vyzul si si navleky");
        }
    }

    @Override
    public boolean daSaPolozit() {
        return !this.obute;
    }
}
