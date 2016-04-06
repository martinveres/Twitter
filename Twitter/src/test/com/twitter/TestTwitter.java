package test.com.twitter;

import static org.junit.Assert.*;

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
}
