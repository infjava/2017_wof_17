package fri.worldOfFri;


import fri.worldOfFri.hra.Hra;

/**
 * Hlavna trieda hry WoF s metodou main - spustanie v NB
 * 
 * @author Lubomir Sadlon
 * @version 21.2.2012
 */
public class Wof00 {

    /**
     * @param args parametre programu
     */
    /*
    - vyhra
    - hadanky (puzzle)
    - questy
        - vysetrenie vrazdy
    - veci
        - navleky
        - sekera
        - uv lampa
        - vzorka dna
    - specialne miestnosti
        - labak sa neda vstupit bez navlekov
        - zamknute miestnosti (otvaranie sekerov)
    - peniaze
    - npc
        - ucitel (predava navleky)
    - boss
        - vrah
    - hudbu do pozadia (zatial nie)
    - 4K (zatial nie)
    - ability
        - hack isic dveri
        - citanie kodu
    - levelovanie
    */
    public static void main(String[] args) {
        Hra hra = new Hra();
        hra.hraj();
    }
}
