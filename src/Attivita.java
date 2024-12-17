public class Attivita{
    private Socio s;
    private Istruttore i;
    private String data;
    private int orarioInizio;
    private int orarioFine;
    private String descrizione;
    public Attivita(Socio s, Istruttore i, String data, int orarioInizio, int orarioFine) {
        this.data = data;
        this.orarioInizio = orarioInizio;
        this.orarioFine = orarioFine;
        this.s = s;
        this.i = i;
    }
    public boolean impegnato(Socio s, Istruttore i, String data, int inizio, int orarioFine){
        if(this.s == s && this.i == i && this.data == data){
            if(orarioFine < this.orarioInizio || inizio > this.orarioFine){
                return false;
            }
        }
        return false;
    }
}