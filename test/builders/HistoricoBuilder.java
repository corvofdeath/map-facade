package builders;

import domain.entities.Disciplina;
import domain.entities.Historico;
import domain.entities.Professor;
import domain.entities.Sala;

public class HistoricoBuilder {

	private Historico historico;
	
	public HistoricoBuilder mockHistoricoBuilder() {
		HistoricoBuilder builder = new HistoricoBuilder();
		Disciplina disciplina = DisciplinaBuilder.mockDisciplina().getDisciplina();
		Sala sala = SalaBuilder.mockSala().getSala();
		Professor professor = ProfessorBuilder.mockProfessor().getProfessor();
		
		builder.historico = new Historico(disciplina.getNome(), sala.getCodigo(), new Double(7.5), professor.getNome());
		
		return builder;
	}
	
	public Historico getHistorico() {
		return this.historico;
	}
}
