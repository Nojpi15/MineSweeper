/**
 * Trieda {@code Pole} slúži na vytvorenie jedného poľa.
 *
 * @author   «meno autora»
 * @version  «verzia alebo dátum»
 */
public class Pole {
    private Boolean JeMina;
    private boolean JeOdhalene;
    
    private int x;

    /**
     * Konštruktory objektov triedy Pole.
     */
    public Pole()
    {
        // Inicializujte inštančné premenné.
        x = 0;
    }


    /**
     * Prázdna metóda – «tento komentár nahraďte vlastným opisom»…
     *
     * @param   y  opis významu parametra
     * @return     opis významu návratovej hodnoty – napr.: súčet x a y
     */
    public int príkladMetódy(int y)
    {
        // Sem vložte príkazy tela metódy.
        return x + y;
    }
}