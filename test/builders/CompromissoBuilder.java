package builders;

import java.util.Date;

import domain.entities.Compromisso;
import domain.enums.Compromissos;
import domain.enums.Setores;

public class CompromissoBuilder {
	
	private Compromisso compromisso;
	
	public static CompromissoBuilder mockCompromisso() {
		CompromissoBuilder builder = new CompromissoBuilder();
		builder.compromisso =  new Compromisso(new Date(), Compromissos.ENTREVISTA, Setores.Diretoria);
		
		return builder;
	}
	
	public Compromisso getCompromisso() {
		return this.compromisso;
	}
}
