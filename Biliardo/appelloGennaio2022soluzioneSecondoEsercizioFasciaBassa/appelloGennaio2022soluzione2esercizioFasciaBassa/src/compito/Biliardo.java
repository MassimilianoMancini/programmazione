package compito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import auxi.Biglia;
import auxi.BigliaNumerata;

public class Biliardo {
	private final List<Buca> buche;

	private final Set<Biglia> tavolo;

	public Biliardo() {
		buche = new ArrayList<>();
		for (int i=0;i<6;i++)
			buche.add(new Buca(new HashSet<Biglia>()));
		
		tavolo = new HashSet<>();
		for (int i=1;i<16;i++)
			tavolo.add(new BigliaNumerata(i));
		tavolo.add(new Biglia());
	}
	
	public List<Buca> getBuche() {
		return buche;
	}

	public Set<Biglia> getTavolo() {
		return tavolo;
	}

}
