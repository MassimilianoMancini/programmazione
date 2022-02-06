package compito;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import auxi.Biglia;
import auxi.BigliaNumerata;

public class BiliardoTest {
	
	private Biliardo bil;
	
	@Before
	public void setup() {
		bil = new Biliardo();
	}
	
	@Test
	public void constructor1DimensioneBuche() {
		assertTrue(bil.getBuche().size()==6);
	}
	
	@Test
	public void constructorBucheVuote() {
		assertTrue(bil.getBuche().stream()
				.allMatch(b -> b.getImbucate().isEmpty()));
	}
	
	
	
	@Test
	public void constructorBiglieSulTavolo() {
		Set<Biglia> s = new HashSet<>(bil.getTavolo());
		assertTrue(s.size()==16);
	}
	
	@Test
	public void constructorBigliaNumerataSulTavolo() {
		Set<Biglia> s = new HashSet<>(bil.getTavolo());
		s.removeIf(b->b instanceof BigliaNumerata);
		assertTrue(s.size()==1);
	}
	
	@Test
	public void constructorBucheTutteDiverse() {
		assertTrue(IntStream.range(0, 6)
		.allMatch(i->IntStream.range(0, 6)
				.allMatch(j->i==j || bil.getBuche().get(i)!=bil.getBuche().get(j))));
	}
	
	////////////
	
}
 