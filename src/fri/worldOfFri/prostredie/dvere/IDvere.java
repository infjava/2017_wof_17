/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie.dvere;

import fri.worldOfFri.prostredie.Miestnost;
import fri.worldOfFri.vynimky.DvereNepriechodneException;

/**
 *
 * @author janik
 */
public interface IDvere {

    Miestnost getCiel(Miestnost odkial)
            throws DvereNepriechodneException;
    
    String getNazov(Miestnost odkial);
    
    Iterable<Miestnost> getVsetkyMozneVychody(Miestnost odkial);
    
}
