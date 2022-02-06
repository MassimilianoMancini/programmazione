package compito;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import auxi.Biglia;

public class BucaTest {
	@Test
	public void testConstructorAndGet() {
		Set<Biglia> imbucate = new HashSet<>();
		Buca test = new Buca(imbucate);
		assertTrue(test.getImbucate()==imbucate);
	}
	

}
