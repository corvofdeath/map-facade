package bussiness.professores;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import builders.ProfessorBuilder;
import domain.entities.Professor;
import domain.enums.Proficiencias;
import repositories.BaseRepository;

public class ProfessorServiceTest {

	private ProfessorService professorService;
	private BaseRepository<Professor> repositorio;
	private Professor professor;
	
	@Before
    public void setUp(){
		this.repositorio = new BaseRepository<Professor>(new ArrayList<Professor>());
		this.professorService = new ProfessorService(this.repositorio);
		this.professor = ProfessorBuilder.mockProfessor().getProfessor();
	}
	
	@Test
	public void testMatricularProfessor() {
		assertEquals(this.professorService.matricularProfessor("Professor", Proficiencias.MATEMATICA, new Double(1200)).getNome(), "Professor");
	}
	
	@Test
	public void testProcurarProfessorDisponivelPorProficiencia() {
		this.professorService.getRepository().save(this.professor);
		assertEquals(this.professorService.procurarProfessorDisponivelPorProficiencia(Proficiencias.MATEMATICA), this.professor);
	}
	
	@Test
	public void testCalcularTempoDeCasa() {
		this.professor.setCreatedAt(new Date());
		assertEquals(this.professorService.calcularTempoDeCasa(this.professor), 0);
	}
}
