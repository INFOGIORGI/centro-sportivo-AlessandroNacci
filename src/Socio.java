public class Socio {
    private String nome;
    private String cognome;
    private String codSocio;

    public Socio(String nome, String cognome, String codSocio) {
        this.nome = nome;
        this.cognome = cognome;
        this.codSocio = codSocio;
    }
    public String toString(){
        return nome + " " + cognome + " " + codSocio;
    }
}