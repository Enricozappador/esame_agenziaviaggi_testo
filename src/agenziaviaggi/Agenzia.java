package agenziaviaggi;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Agenzia {
	private Map<String, Cliente> clienti;
	private int numclienti ; 
	private Map<Integer, Pratica> pratiche; 
	private int pratid; 

	
	public Agenzia() {
		clienti = new TreeMap<String, Cliente>(); 
		numclienti = 0; 
		pratiche = new TreeMap<Integer, Pratica>(); 
		pratid = 1000; 
		
	}
	

	public Cliente aggiungiCliente(String cognome, String nome, String indirizzo) throws EccezioneClienteGiaEsistente {
		String chiave = cognome +" "+  nome +" " + indirizzo;
		Cliente ctemp = new Cliente(chiave ,cognome, nome, indirizzo ); 

		if (clienti.containsKey(chiave) == true) {
			throw new EccezioneClienteGiaEsistente();
		}
		
		else 
			clienti.put(chiave, ctemp);
			
			
		/*for(Cliente c : clienti) {
			if(c!= null )
			{
				for (Cliente a : clienti)
				{
					if (a!= null && a.getCognome().compareTo(c.getCognome())==0 && a.getNome().compareTo(c.getNome())==0)
					{
						for (Cliente b : clienti )
							if(b!= null && b.getIndirizzo().compareTo(a.getIndirizzo())==0 )
								flag = true;
					}
				}
			}
		}
		
	*/
		
		/*if (flag == false)
		{
			clienti.add(numclienti++, ctemp);
			
		}
		else if (flag == true ) {
				ctemp = null;
				
			}
			*/
		
		return ctemp;
	}
	
	public Collection<Cliente> elencoClienti(){
		LinkedList<Cliente> ctemp = new LinkedList<Cliente>(clienti.values()); 
		//LinkedList <String> stemp = new LinkedList <String> (); 
		/*int x = 0; 
		int y= 0; 
		
		
		for(Cliente c : clienti)
			if(c!=null)
			{
				stemp.add(x++, c.getNome()+c.getCognome()+c.getIndirizzo());
			}
				Collections.sort(stemp); 
				
				for (String s : stemp) {
					if (s!=null) {
						for (Cliente c : clienti ) {
							if ( c!= null && s.compareTo(c.getNome()+c.getCognome()+c.getIndirizzo())==0) {
								
								
							}
						}
					}
				}
		*/
		
		return ctemp;
	}
	
	public Cliente cercaCliente(String cognome, String nome, String indirizzo){
		Cliente ctemp = null;
		String chiave = cognome+" "+nome+" "+indirizzo; 
		if(clienti.containsKey(chiave) == true)
			ctemp = clienti.get(chiave); 
		
		return ctemp;
	}
	
	public Cliente cercaCliente(String ricerca){
		Cliente ctemp = null; 
		LinkedList <Cliente> ctemp1 = new LinkedList<Cliente>(clienti.values());
		String prova = ""; 
		boolean flag = false; 
		//LinkedList <String> stemp = new LinkedList<String>(); 
		for (Cliente c : ctemp1) {
			if(c!=null && flag == false) {
				//prova = c.getKey().toUpperCase(); 
			//if(prova) {
				flag = true; 
				return c; 
				//}
			}
		}
		/*Cliente ctemp = null; 
		if(clienti.containsKey(ricerca)==true)
			ctemp = clienti.get(ricerca);
	*/
		return null; 
		
	}
	
	public int nuovaPratica(String descrizione, String cognome, String nome, String indirizzo) throws EccezioneClienteGiaEsistente{
		Pratica ptemp = null ; 
		String chiave = cognome+" "+nome+" "+indirizzo; 
		Cliente ctemp = this.cercaCliente(cognome, nome, indirizzo);
		
		
		
		/*if(clienti.containsKey(chiave)==true)
		{
		ptemp = new Pratica (pratid, descrizione); 	
		pratiche.put(pratid++, ptemp); 
		;
		clienti.get(chiave).aggiungiPratica(ptemp);
		
		}
		else {
			aggiungiCliente(cognome, nome ,indirizzo);  
			
		}
			
			
		*/
		if(ctemp == null) {
			ctemp= new Cliente (chiave, cognome, nome, indirizzo);
			clienti.put(chiave, ctemp);
		}
		 
			ptemp = new Pratica (pratid, descrizione, ctemp); 
			pratiche.put(pratid, ptemp); 
			pratid++; 
			ctemp.aggiungiPratica(ptemp);
		
		
		
		return ptemp.getIdPratica();
	}
	
	public Pratica getPratica(int idPratica) throws EccezionePraticaInesistente{
		Pratica ptemp= null; 
		if(pratiche.containsKey(idPratica)==true)
		ptemp = 	pratiche.get(idPratica); 
		else
			throw new EccezionePraticaInesistente(); 
		return ptemp;
	}
	
	public void eliminaPratica(int idPratica) throws EccezionePraticaInesistente{
		Pratica ptemp = null; 
		if(pratiche.containsKey(idPratica)==true) {
			ptemp = pratiche.get(idPratica);
			pratiche.remove(idPratica, ptemp);
		}
		else 
			throw new EccezionePraticaInesistente(); 
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

	public double calcolaImportoPerPeriodo(String da, String a){
		
		return -1.0;
	}
	
	public Collection<Cliente> elencoClientiSelezionati(double importo){
		return null;
	}
}
