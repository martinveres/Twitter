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
	 * @return 
	 */
	public String getKorisnik() {
	return korisnik;
	}
	/**
	 * Kao paremetar se prima korisnik, koji se smesta u promenljivu korisnik, ukoliko njegova vrednost nije null, ili prazan string.
	 * @param korisnik
	 * @throws RuntimeException
	 */
	public void setKorisnik(String korisnik) {
	if (korisnik==null || korisnik == "")
	throw new RuntimeException(
	"Ime korisnika mora biti uneto");
	this.korisnik = korisnik;
	}
	/**
	 * Metoda vraca String "poruka". Pretpostavlja se da je u pitanju greska.
	 * @return 
	 */
	public String getPoruka() {
	return poruka;
	}
	/**
	 * Kao parametar se prima poruka, koja se smesta u promenljivu poruka ukoliko njena vrednost nije null, ili ako velicina ne prekoracuje 140 karaktera.
	 * @param poruka
	 * @throws RuntimeException
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
