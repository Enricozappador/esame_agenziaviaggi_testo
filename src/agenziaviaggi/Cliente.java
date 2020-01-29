package agenziaviaggi;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Cliente{
	private String cognome; 
	private String nome; 
	private String indirizzo;
	private LinkedList <String> contatti = new LinkedList<String>(); 
	private Map<Integer, Pratica> pratiche = new TreeMap<Integer, Pratica>(); 
	private String key;
	private int numcontatti; 
	
	public Cliente(String key, String cognome, String nome, String indirizzo) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.indirizzo = indirizzo;
		//this.contatti = contatti;
		//this.pratiche = pratiche;
		numcontatti = 0; 
	}


	
	
	
	public String getCognome(){
		return cognome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getIndirizzo(){
		return indirizzo;
	}

	public void aggiungiContatto(String contatto){
		
		for (String s : contatti)
		{
			if(s!= null && s.compareTo(contatto)==0)
			{
				return;
			}
			
		}
		
			contatti.add(contatto);
	}

	public Collection<String> elencoContatti(){
		
		return contatti;
	}

	public Collection<Pratica> elencoPratiche(){
		LinkedList<Pratica> ptemp = new LinkedList<Pratica>(pratiche.values()); 
		LinkedList<String> stemp = null; 
		
		/*for(Pratica p : ptemp) {
			if(p!=null) {
				
				String s = String.valueOf(p.getImportoTotale());
				stemp.add(s);
				
			}
		}
		Collections.sort(stemp);;
		*/
	
		return ptemp;
	}
	
	public void aggiungiPratica(Pratica p) {
		pratiche.put(p.getIdPratica(), p);
	}





	public String getKey() {
		return key;
	}





	public void setKey(String key) {
		this.key = key;
	}
}
