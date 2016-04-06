package com.twitter.poruke;

/**
 * 
 * @author Martin Veres
 * @version 1.0
 *Klasa TwitterPoruke
 */
public class TwitterPoruka {
	/**
	 * Predstavlja korisnicko ime.
	 */
	private String korisnik;
	/**
	 * Predstavlja poruku koja se salje.
	 */
	private String poruka;
	/**
	 * Metoda vraca korisnika.
	 * @return korisnik
	 */
	public String getKorisnik() {
	return korisnik;
	}
	/**
	 * Kao paremetar se prima korisnik, koji se smesta u promenljivu korisnik.
	 * @param korisnik username
	 * @throws RuntimeException null ili prazan string
	 */
	public void setKorisnik(String korisnik) {
	if (korisnik==null || korisnik == "")
	throw new RuntimeException(
	"Ime korisnika mora biti uneto");
	this.korisnik = korisnik;
	}
	/**
	 * Metoda vraca String "poruka". Pretpostavlja se da je u pitanju greska.
	 * @return poruka
	 */
	public String getPoruka() {
	return poruka;
	}
	/**
	 * Kao parametar se prima poruka.
	 * @param poruka tekst poruke
	 * @throws RuntimeException <ul>
	 * 		<li> null </li>
	 * 		<li> broj karaktera >140 </li>
	 * </ul>
	 */ 
	public void setPoruka(String poruka) {
	if (poruka==null || poruka.length()>140)
	throw new RuntimeException(
	"Poruka mora biti uneta i mora imati najvise 140 znakova");
	this.poruka = poruka;
	}
	/**
	 * Metoda koja vraca sve atribute klase, u obliku stringa.
	 */
	public String toString(){
	return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	} 
}
