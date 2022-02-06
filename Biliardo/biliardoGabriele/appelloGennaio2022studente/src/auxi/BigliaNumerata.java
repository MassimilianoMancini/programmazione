package auxi;

public class BigliaNumerata extends Biglia {

	private final Integer value;
	
	public BigliaNumerata(Integer value) {
		super();
		this.value = value;
	}
	

	public Integer getValue() {
		return value;
	}


	
	public boolean equals(BigliaNumerata obj) {
		
		return this.value==obj.getValue();
	}
	
	
	
}