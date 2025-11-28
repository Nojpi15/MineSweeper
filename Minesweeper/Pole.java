/**
 * Trieda {@code Pole} slúži na vytvorenie jedného poľa.
 *
 * @author   «meno autora»
 * @version  «verzia alebo dátum»
 */
import fri.shapesge.Stvorec; 

public class Pole {
    private Stvorec stvorec;
    private Boolean jeMina;
    private boolean jeOdhalene;
    private boolean nieJeOdhalene;
    

    /**
     * Konštruktory objektov triedy Pole.
     */
    public Pole(int x, int y, int velkost) {
        this.stvorec = new Stvorec();
        this.stvorec.zmenStranu(velkost - 1);
        this.stvorec.posunVodorovne(-60 + x * velkost);
        this.stvorec.posunZvisle(-50 + y * velkost);
        this.stvorec.zobraz();
        zaberPole();
    }
    public void odhal(){
        this.nieJeOdhalene = true;
        this.jeOdhalene = false;
        this.zaberPole();
    }
    public void jeOdhalene(){
        this.nieJeOdhalene = false;
        this.jeOdhalene = true;
        this.zaberPole();
    }
    public void zaberPole() {
        if (this.jeOdhalene = false) {
            this.stvorec.zmenFarbu("#B1C9EE");
        } else if (this.jeOdhalene = true) {
            this.stvorec.zmenFarbu("#CFDEE7");
        } 
    }
    public boolean getJeOdhalene(){
        return this.jeOdhalene;
    }
    public boolean getNieJeOdhalene(){
        return this.nieJeOdhalene;
    }


    
}