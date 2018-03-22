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
        - operacie
            - prenasat
            - pouzit
                > pouzi sekera
            - zdvihnut
                > zdvihni sekera
            - polozit
                > poloz sekera
            - zobrazenie "statov"
                > staty
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
    /*
    priklad rozhovoru:
    > hovor ucitel
    A) dobry den
    B) nemate navleky?
    > A
    dobry den
    co potrebujete?
    A) nemate navleky?
    B) nemate pizzu?
    > A
    nech sa paci (da nam navleky)
    
    > hovor ucitel
    A) dobry den
    B) nemate navleky?
    > A
    dobry den
    co potrebujete?
    A) nemate navleky?
    B) nemate pizzu?
    > B
    chrum chrum chrum... uz nie
    A) nemate navleky?
    > A
    nech sa paci (da nam navleky)
    
    > hovor ucitel
    A) dobry den
    B) nemate navleky?
    > B
    nie (50% sanca ze sa nastve, ak nemam sekeru, konci hra)
    */
    public static void main(String[] args) {
        Hra hra = new Hra();
        hra.hraj();
    }
}
