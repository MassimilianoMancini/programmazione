package compito;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import auxi.Biglia;
import auxi.BigliaNumerata;

public class Biliardo {
	private final List<Buca> buche;

	private final Set<Biglia> tavolo;

	public Biliardo() {
		buche = Stream.generate(()->new Buca(new HashSet<Biglia>()))
				.limit(6)
				.collect(Collectors.toList());
		
		tavolo = IntStream.range(1,16)
				.mapToObj(i->new BigliaNumerata(i))
				.collect(Collectors.toSet());
		
		tavolo.add(new Biglia());
	}

	public Biliardo(List<Buca> buche, Set<Biglia> tavolo) {
		List<Biglia> temp = Stream.concat(buche.stream()
				.map(Buca::getImbucate)
				.flatMap(Set::stream),
				tavolo.stream())
				.collect(Collectors.toList());

		check(temp, b -> Collections.frequency(temp, b) > 1);
		check(temp, b ->(b instanceof BigliaNumerata) && 
				(((BigliaNumerata) b).getValue()<1 || ((BigliaNumerata) b).getValue()>15));

		this.buche=buche;
		this.tavolo=tavolo;
	}
	
	public List<Buca> getBuche() {
		return buche;
	}

	public Set<Biglia> getTavolo() {
		return tavolo;
	}

	private void check(List<Biglia> temp, Predicate<Biglia> pred) {
		temp.stream().filter(pred)
		.findAny().ifPresent(c -> {throw new IllegalArgumentException();});
	}
	
	public boolean gameOver() {
		return buche.stream()
				.map(Buca::getImbucate)
				.flatMap(Set::stream)
				.anyMatch(b-> (b instanceof BigliaNumerata) && ((BigliaNumerata)b).getValue()==8);
	}

	public boolean pallinoImbucato() {
		return buche.stream()
				.map(Buca::getImbucate)
				.flatMap(Set::stream)
				.anyMatch(b-> b.getClass().equals(Biglia.class));
	}
	
	public void reset() {
		buche.forEach(b -> {
			tavolo.addAll(b.getImbucate());
			b.getImbucate().clear();
		});
		
	}

}
