package test.com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TestTwitter {
Twitter t;
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}
	@Test
	public void testVratiSvePoruke() {
		t.unesi("M", "AA");
		t.unesi("T", "Ae");
		LinkedList<TwitterPoruka> poruke = t.vratiSvePoruke();
		assertEquals(poruke.get(0).getKorisnik(), "M");
		assertEquals(poruke.get(1).getKorisnik(), "T");
		assertEquals(poruke.get(0).getPoruka(), "AA");
		assertEquals(poruke.get(1).getPoruka(), "Ae");
	}
	@Test
	public void testUnesiOK() {
		t.unesi("Jovan", "Dobar dan");
		assertEquals(t.vratiSvePoruke().getLast().getKorisnik(), "Jovan");
		assertEquals(t.vratiSvePoruke().getLast().getPoruka(), "Dobar dan");
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesikorisnikNull() {
		t.unesi("Jovan", null);
		
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPorukaNull() {
		t.unesi(null, "Dobar dan");
		
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiObaNull() {
		t.unesi(null, null);
		
	}
	@Test
	public void testVratiPorukeOK() {
		t.vratiPoruke(10, "Mar");
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(11, null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(11, "");
	}
	@Test()
	public void testVratiPorukeNegativanMaxBrojStringOK() {
		t.vratiPoruke(-6,"a");
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNegativanMaxBrojStringNull() {
		t.vratiPoruke(-6,null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNegativanMaxBrojStringPrazan() {
		t.vratiPoruke(-6,"");
	}
	@Test
	public void testVratiPorukeVracaSeNizSaMaksBrojElemenata() {
		TwitterPoruka[] ta = new TwitterPoruka[2];
		t.unesi("Joca", "Mama lepo kuva.");
		t.unesi("Joca", "Moja mama lepo kuva.");
		t.unesi("Joca", "Milanova mama lepo kuva.");
		ta = t.vratiPoruke(2, "M");
	}
}
