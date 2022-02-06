package compito;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import auxi.Biglia;
import auxi.BigliaNumerata;

public class BiliardoTestOpzionali {
	
	@Test
	public void constructorBucheDoppioni() {
		Set<Biglia> s = new HashSet<>();
		s.add(new BigliaNumerata(8));
		List<Buca> buche = new ArrayList<>();
		buche.add(new Buca(s));
		buche.add(new Buca(s));
		
		Set<Biglia> tavolo = new HashSet<>();
		
		assertThatThrownBy(() -> new Biliardo(buche,tavolo))
		.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void constructorBigliaDoppione() {
		Biglia b = new BigliaNumerata(8);
		Set<Biglia> s = new HashSet<>();
		s.add(b);
		List<Buca> buche = new ArrayList<>();
		buche.add(new Buca(s));
		buche.add(new Buca(new HashSet<>()));

		Set<Biglia> tavolo = new HashSet<>();
		tavolo.add(b);
		
		assertThatThrownBy(() -> new Biliardo(buche,tavolo))
		.isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void constructorBigliaNumerataMale() {
		Biglia b = new BigliaNumerata(8);
		Set<Biglia> s = new HashSet<>();
		s.add(b);
		List<Buca> buche = new ArrayList<>();
		buche.add(new Buca(s));
		buche.add(new Buca(new HashSet<>()));

		Set<Biglia> tavolo = new HashSet<>();
		tavolo.add(new BigliaNumerata(0));
		
		assertThatThrownBy(() -> new Biliardo(buche,tavolo))
		.isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void constructorBigliaNumerataMale2() {
		Biglia b = new BigliaNumerata(8);
		Set<Biglia> s = new HashSet<>();
		s.add(b);
		List<Buca> buche = new ArrayList<>();
		buche.add(new Buca(s));
		buche.add(new Buca(new HashSet<>()));

		Set<Biglia> tavolo = new HashSet<>();
		tavolo.add(new BigliaNumerata(16));
		
		assertThatThrownBy(() -> new Biliardo(buche,tavolo))
		.isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void reset1() {
		Biglia b8 = new BigliaNumerata(8);
		Biglia pallino = new Biglia();
		Set<Biglia> s = new HashSet<>();
		s.add(b8);
		List<Buca> buche = new ArrayList<>();
		buche.add(new Buca(s));
		buche.add(new Buca(new HashSet<>(Arrays.asList(pallino))));

		Set<Biglia> tavolo = new HashSet<>();
		
		Biliardo bili = new Biliardo(buche,tavolo);
		
		bili.reset();
		
		assertTrue(bili.getBuche().stream()
				.allMatch(b -> b.getImbucate().isEmpty()));
	}
	
	@Test
	public void reset2() {
		Biglia b8 = new BigliaNumerata(8);
		Biglia pallino = new Biglia();
		Set<Biglia> s = new HashSet<>();
		s.add(b8);
		List<Buca> buche = new ArrayList<>();
		buche.add(new Buca(s));
		buche.add(new Buca(new HashSet<>(Arrays.asList(pallino))));

		Set<Biglia> tavolo = new HashSet<>();
		
		Biliardo bili = new Biliardo(buche,tavolo);
		
		bili.reset();
		
		assertTrue(bili.getTavolo().containsAll(Arrays.asList(pallino,b8)));
	}	
	
	@Test
	public void reset3() {
		Biglia b8 = new BigliaNumerata(8);
		Biglia pallino = new Biglia();
		Set<Biglia> s = new HashSet<>();
		s.add(b8);
		List<Buca> buche = new ArrayList<>();
		buche.add(new Buca(s));
		buche.add(new Buca(new HashSet<>(Arrays.asList(pallino))));

		Set<Biglia> tavolo = new HashSet<>();
		
		Biliardo bili = new Biliardo(buche,tavolo);
		
		bili.reset();
		
		assertTrue(bili.getTavolo().size()==2);
	}	
	
	@Test
	public void testGameOverTrue() {
		Biglia b8 = new BigliaNumerata(8);
		Biglia pallino = new Biglia();
		Set<Biglia> s = new HashSet<>();
		s.add(b8);
		List<Buca> buche = new ArrayList<>();
		buche.add(new Buca(s));
		buche.add(new Buca(new HashSet<>(Arrays.asList(pallino))));

		Set<Biglia> tavolo = new HashSet<>();
		
		Biliardo bili = new Biliardo(buche,tavolo);
		
		
		assertTrue(bili.gameOver());
	}	
	
	@Test
	public void testGameOverFalse() {
		Biglia b8 = new BigliaNumerata(8);
		Biglia pallino = new Biglia();
		Set<Biglia> s = new HashSet<>();
		
		List<Buca> buche = new ArrayList<>();
		buche.add(new Buca(s));
		buche.add(new Buca(new HashSet<>(Arrays.asList(pallino))));

		Set<Biglia> tavolo = new HashSet<>();
		tavolo.add(b8);
		
		Biliardo bili = new Biliardo(buche,tavolo);
		
		assertFalse(bili.gameOver());
	}	
	
	@Test
	public void testPallinoImbucatoTrue() {
		Biglia b8 = new BigliaNumerata(8);
		Biglia pallino = new Biglia();
		Set<Biglia> s = new HashSet<>();
		s.add(b8);
		List<Buca> buche = new ArrayList<>();
		buche.add(new Buca(s));
		buche.add(new Buca(new HashSet<>(Arrays.asList(pallino))));

		Set<Biglia> tavolo = new HashSet<>();
		
		Biliardo bili = new Biliardo(buche,tavolo);
		
		
		assertTrue(bili.pallinoImbucato());
	}	
	
	
	@Test
	public void testPallinoImbucatoFalse() {
		Biglia b8 = new BigliaNumerata(8);
		Biglia pallino = new Biglia();
		Set<Biglia> s = new HashSet<>();
		s.add(b8);
		List<Buca> buche = new ArrayList<>();
		buche.add(new Buca(s));
		buche.add(new Buca(new HashSet<>()));

		Set<Biglia> tavolo = new HashSet<>();
		tavolo.add(pallino);
		
		Biliardo bili = new Biliardo(buche,tavolo);
		
		
		assertFalse(bili.pallinoImbucato());
	}	
}
 