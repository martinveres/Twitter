package com.twitter;
import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * 
 * @author Martin veres
 * @version 2.0
 *
 */
public class Twitter {
	/**
	 * Lista Twitter poruka
	 */
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	/**
	 * Metoda koja vraca sve poruke.
	 * @return poruke
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Metoda za unos nove poruke. Kreira se nova Twitter Poruka, zatim joj se dodele parametri, a nakon toga se dodaje u listu poruka.
	 * Moguce je da ce biti potrebno dodavanje provere parametara.
	 * @param korisnik username
	 * @param poruka tekst poruke
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda koja pretrazuje listu poruka. Vraca niz sa maxBroj elemenata koji sadrze zadati tag.
	 * Tag mora biti:
	 * <ul>
	 * 		<li> Razlicut od null </li>
	 * 		<li> Razlicit od "" </li>
	 * </ul>
	 * maxBroj moze biti 0, i tada se on postavlja na 100.
	 * @param maxBroj maksimalan broj vracenih poruka
	 * @param tag kljucna rec po kojoj se pretrazuju poruke
	 * @return niz poruka
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0; 
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
	}
} 