package agenziaviaggi;

import java.util.Collection;
import java.util.LinkedList;

public class Pratica{
	private int id; 
	private String descrizione; 
	private LinkedList<Prenotazione> prenotazioni; 
	private Cliente clienti; 

	

	public Pratica(int id, String desrizione, Cliente clienti) {
		super();
		this.id = id;
		this.descrizione = desrizione;
		this.clienti = clienti; 
		prenotazioni = new LinkedList<Prenotazione>(); 
	}

	public int getIdPratica(){
		return id;
	}
	
	public String getDescrizione(){
		return descrizione;
	}
	
	public void aggiungiPrenotazione(Prenotazione prenotazione){
		
		prenotazioni.add(prenotazione); 
	}
	
	public double getImportoTotale(){
		double totale = 0.0; 
		for (Prenotazione p : prenotazioni) {
			if(p!=null)
				totale = totale+p.getImporto(); 
		}
		return totale;
	}
	
	public Collection<Prenotazione> elencoPrenotazioniPerImporto()
	{  LinkedList<Prenotazione> ptemp = new LinkedList(prenotazioni); 
	
		return ptemp;
	}

	public Collection<Prenotazione> elencoPrenotazioniPerData()
	{ 
		LinkedList<Prenotazione> ptemp = new LinkedList(prenotazioni); 
		
		return ptemp;
	}
}
