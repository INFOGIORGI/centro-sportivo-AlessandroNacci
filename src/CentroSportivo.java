import java.util.HashMap;

public class CentroSportivo {
    HashMap<String, Socio> soci = new HashMap<>();
    HashMap<String, Istruttore> istruttori = new HashMap<>();
    HashMap<Socio, Attivita> attivitaa = new HashMap<>();
    HashMap <Socio, Istruttore> assegna = new HashMap<>();

    public boolean aggiungiSocio(String nome, String cognome, String cs){
        Socio s = new Socio(nome, cognome, cs);
        if(soci.containsKey(cs)){
            return false;
        } else {
            soci.put(cs,s);
            return true;
        }
    }

    public boolean deleteSocio(String codSocio){
        if(soci.containsKey(codSocio) && !assegna.containsKey(soci.get(codSocio))){
            soci.remove(codSocio);
            return true;
        } else if (!soci.containsKey(codSocio)){
            return false;
        }
        return false;
    }

    public boolean aggiungiIstruttore(String nome, String cognome, String ci){
        Istruttore i = new Istruttore(nome, cognome, ci);
        if(istruttori.containsKey(ci)){
            return false;
        } else {
        istruttori.put(ci,i);
        return true;
        }
    }

    public boolean deleteIstruttore(String codIstruttore){
        if(istruttori.containsKey(codIstruttore)){
            Istruttore istruttore = istruttori.get(codIstruttore);
            boolean istruttoreTrovato = false;
            for(Socio key: assegna.keySet()){
                if(assegna.get(key).equals(istruttore)){
                    istruttoreTrovato = true;
                }
            } 
            if(istruttoreTrovato == false){
                istruttori.remove(codIstruttore);
                return true;
            }
        } else if (!istruttori.containsKey(codIstruttore)) {
            return false;
        }
        return false;
    }

    public Socio getSocio(String cs){
            if(soci.containsKey(cs)){
                return soci.get(cs);
            }
        return null;
    }

    public Istruttore getIstruttore(String ci){
            if(istruttori.containsKey(ci)){
                return istruttori.get(ci);
            }
        return null;
    }

    public boolean setIstruttore(String cs, String ci){
        Socio s = getSocio(cs);
        Istruttore i = getIstruttore(ci);       
        if (s != null && i != null) {
            assegna.put(s,i);
            return true;
        } 
          return false;
    }

    public boolean deleteAssociazione(String cs, String ci){
        Socio s = getSocio(cs);
        Istruttore i = getIstruttore(ci);
        if (s != null && i != null) {
            assegna.remove(s,i);
            return true;
        }
        return false;
    }

    public String getSoci(String ci){
        Istruttore i = getIstruttore(ci);
        String retValue = "";
        for(Socio s : assegna.keySet()){
            if(assegna.get(s).equals(i)){
                retValue += s.toString();
            }
        }
        return retValue;
    }

    public boolean aggiungiAttivita(String cs, String ci, String data, int oi, int of){
        Socio s = getSocio(cs);
        Istruttore i = getIstruttore(ci);
        if(s != null && i != null){
            if(assegna.containsKey(s) && assegna.get(s).equals(i)){
                for(Socio s1: attivitaa.keySet()){
                    Attivita ac = attivitaa.get(s1);
                    if(ac.impegnato(s, i, data, oi, of)){
                        return false;
                    }
                }
                Attivita a = new Attivita(s, i, data, oi, of);
                attivitaa.put(s, a);
                return true;
            }
        }
        return false;
    }

}