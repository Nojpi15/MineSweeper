
/**
 * Trieda {@code Grid} slúži na «doplňte opis»…
 *
 * @author   «meno autora»
 * @version  «verzia alebo dátum»
 */
public class Grid
{
    // Nahraďte nižšie uvedený príklad vlastnými premennými…

    // inštančné premenné…
    private Pole[][] policka;    
    private int sirka;
    private int vyska;
    private int velkostPolicka;


    /**
     * Konštruktory objektov triedy Grid.
     */
    public Grid(int sirka, int vyska, int velkostPolicka) {
        this.sirka = sirka;
        this.vyska = vyska;
        this.velkostPolicka = velkostPolicka;
        this.policka = new Pole[vyska][sirka];      
        for (int y = 0; y < vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                this.policka[y][x] = new Pole(x, y, velkostPolicka);
            }
        }
    }
    
    public void zaber(int x, int y) {
        Pole p = this.policka[y][x];
        if (p.getNieJeOdhalene() == true ) {
            p.odhal();
        } else if (p.getJeOdhalene() == true) {
            p.jeOdhalene();
        }
        }
    }

    
