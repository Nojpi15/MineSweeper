/**
 * Trieda {@code Pole} slúži na vytvorenie jedného poľa.
 *
 * @author   «meno autora»
 * @version  «verzia alebo dátum»
 */
import fri.shapesge.Stvorec;
public class Pole {
    private Stvorec stvorec;
    private boolean jeMina;
    private boolean jeOdhalene;
    private int pocetSusednychMin;
    private int x;
    private int y;
    private int velkost;
    /**
     * Konštruktory objektov triedy Pole.
     */
    public Pole(int x, int y, int velkost) {
        this.x = x;
        this.y = y;
        this.velkost = velkost;
        this.jeMina = false;
        this.jeOdhalene = false;
        this.pocetSusednychMin = 0;
        this.stvorec = new Stvorec();
        this.stvorec.zmenStranu(velkost - 1);
        this.stvorec.posunVodorovne(-60 + x * velkost);
        this.stvorec.posunZvisle(-50 + y * velkost);
        this.stvorec.zmenFarbu("#B1C9EE"); 
        this.stvorec.zobraz();
    }

    public void odhal() {
        if (!this.jeOdhalene) {
            this.jeOdhalene = true;
            if (this.jeMina) {
                // Červená farba pre mínu
                this.stvorec.zmenFarbu("#FF0000");
            } else if (this.pocetSusednychMin > 0) {
                // Rôzne farby podľa počtu susedných mín
                this.stvorec.zmenFarbu(this.getFarbuPodlaCisla());
            } else {
                // Biele pole bez mín okolo
                this.stvorec.zmenFarbu("#FFFFFF");
            }
        }
    }

    public void nastavMinu(){
        this.jeMina = true;
        //this.stvorec.zmenFarbu("#8B0000");
    }

    public void nastavPocetSusednychMin(int pocet) {
        this.pocetSusednychMin = pocet;
    }

    /**
     * Vráti farbu podľa počtu susedných mín.
     */
    private String getFarbuPodlaCisla() {
        switch (this.pocetSusednychMin) {
            case 1: return "#E8F4FF"; // Svetlo modrá
            case 2: return "#C5E3FF"; // Modrá
            case 3: return "#FFE5CC"; // Svetlo oranžová
            case 4: return "#FFCCAA"; // Oranžová
            case 5: return "#FFB088"; // Tmavšia oranžová
            case 6: return "#FF9966"; // Červeno-oranžová
            case 7: return "#FF7744"; // Tmavo oranžová
            case 8: return "#FF5522"; // Červená
            default: return "#FFFFFF"; // Biela
        }
    }

    public int getPocetSusednychMin() {
        return this.pocetSusednychMin;
    }

    public boolean jeUzOdhalene() {
        return this.jeOdhalene;
    }

    public void vlajka() {
        this.stvorec.zmenFarbu("#00FF00");
    }
}