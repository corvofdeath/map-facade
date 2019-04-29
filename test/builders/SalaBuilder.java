package builders;

import domain.entities.Sala;

public class SalaBuilder {

	private Sala sala;
	
	public static SalaBuilder mockSala() {
		SalaBuilder builder = new SalaBuilder();
		builder.sala = new Sala("c202");
		
		return builder;
	}
	
	public Sala getSala() {
		return this.sala;
	}
}
