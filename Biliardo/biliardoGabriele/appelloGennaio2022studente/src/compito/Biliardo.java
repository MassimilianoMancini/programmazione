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
		
		this.buche=new ArrayList<Buca>();
		
		for(int i=0; i<6; i++) {
			buche.add(new Buca(new HashSet<Biglia>()));
		}
		
		//Buca biglia1= new Buca(new HashSet<Biglia>());
		//buche.add(biglia1);
		
		this.tavolo = new HashSet<>();
		
		for(int i=1; i<=15; i++) {
			tavolo.add(new BigliaNumerata(i)); //le 14 bigliaNumerate
		}
		tavolo.add(new Biglia()); //la 15 biglia
		
	}

	public Biliardo(List<Buca> buche, Set<Biglia> tavolo) {
		this.buche = buche;
		this.tavolo = tavolo;
		
	}
	
	

	
	public List<Buca> getBuche() {
		return buche;
	}

	public Set<Biglia> getTavolo() {
		return tavolo;
	}

	public boolean gameOver() {
		return buche.stream()
			.anyMatch(x -> x.getImbucate().stream()
				.anyMatch(b-> (b instanceof BigliaNumerata) && ((BigliaNumerata)b).getValue()==8));

	}

	public boolean pallinoImbucato() {
		//stub
		return false;
	}
	
	public void reset() {
		//stub
	}

}
