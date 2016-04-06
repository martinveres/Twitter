package test.com.twitter.poruke;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;


public class TestTwitterPoruka {
	TwitterPoruka tw;
	@Before
	public void setUp() throws Exception {
		tw = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tw = null;
	}
	@Test 
	public void testSetKorisnikSveOk() {
		tw.setKorisnik("Marko");
		assertEquals("Marko", tw.getKorisnik());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisniknull() {
		tw.setKorisnik(null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tw.setKorisnik("");
	}
	@Test
	public void testSetPorukaSveOk() {
		tw.setPoruka("Poruka");
		assertEquals("Poruka", tw.getPoruka());
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tw.setPoruka(null);
	}
	@Test
	public void testSetPorukaTacno140() {
		String s = "";
		for (int i = 0; i < 140; i++) {
			if(i%2==0) {
				s+="M";
			}
			else {
				s+="a";
			}
		}
		tw.setPoruka(s);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaPreko140() {
		String s = "";
		for (int i = 0; i < 144; i++) {
			if(i%2==0) {
				s+="M";
			}
			else {
				s+="a";
			}
		}
		tw.setPoruka(s);
	}
	@Test 
	public void testToString() {
		tw.setKorisnik("Korisnik");
		tw.setPoruka("Danas je veoma toplo :)");
		assertEquals("KORISNIK:Korisnik PORUKA:Danas je veoma toplo :)", tw.toString());
	}
}
