package bussiness.infra;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import builders.DisciplinaBuilder;
import builders.ProfessorBuilder;
import builders.SalaBuilder;
import domain.entities.Disciplina;
import domain.entities.Professor;
import domain.entities.Sala;
import repositories.BaseRepository;

public class SalasServicesTest {
	
	private SalasServices salasServices;
	private BaseRepository<Sala> repositorio;
	private Sala sala;
	private Professor professor;
	private Disciplina disciplina;
	
	@Before
    public void setUp(){
		this.repositorio = new BaseRepository<Sala>(new ArrayList<Sala>());
		this.salasServices = new SalasServices(repositorio);
		this.sala = SalaBuilder.mockSala().getSala();
		this.professor = ProfessorBuilder.mockProfessor().getProfessor();
		this.disciplina = DisciplinaBuilder.mockDisciplina().getDisciplina();
	}
	
	@Test
	public void testCriarSala() {
		assertEquals(this.salasServices.criarSala(this.sala.getCodigo()).getCodigo(), this.sala.getCodigo());
	}
	
	@Test
	public void testAlocarSala() {
		this.salasServices.getRepository().save(this.sala);
		assertEquals(this.salasServices.alocarSala(this.sala.getCodigo(), this.professor, this.disciplina), this.sala);
	}
}
