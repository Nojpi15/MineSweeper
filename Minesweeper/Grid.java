
/**
 * Trieda {@code Grid} slúži na «doplňte opis»…
 *
 * @author   «meno autora»
 * @version  «verzia alebo dátum»
 */

import java.util.Random; 

public class Grid {
    
    private Pole[][] policka;
    private boolean[][] miny;
    private int sirka;
    private int vyska;
    private int velkostPolicka;

    /**
     * Konštruktory objektov triedy Grid.
     */
    public Grid(int sirka, int vyska, int velkostPolicka, int pocetMin) {
        this.sirka = sirka;
        this.vyska = vyska;
        this.velkostPolicka = velkostPolicka;
        
        this.policka = new Pole[vyska][sirka];  
        this.miny = new boolean[vyska][sirka];
        
        for (int y = 0; y < vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                this.policka[y][x] = new Pole(x, y, velkostPolicka);
            }
        }
        
        generujMiny(pocetMin);
    }
    
    public void generujMiny(int pocetMin) {
        Random r = new Random();
        int vlozene = 0;
    
    }

    public Pole getPole(int x, int y) {
        if (x >= 0 && x < this.sirka && y >= 0 && y < this.vyska) {
            return this.policka[y][x];
        }
        return null;
    }

    public int getSirka() {
        return this.sirka;
    }

    public int getVyska() {
        return this.vyska;
    }

    public int getVelkostPolicka() {
        return this.velkostPolicka;
    }

    public void odhalPole(int x, int y) {
        Pole pole = this.getPole(x, y);
        if (pole != null) {
            pole.odhal();
        }

    }
}

