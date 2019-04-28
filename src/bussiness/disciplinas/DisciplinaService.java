package bussiness.disciplinas;

import domain.entities.Disciplina;
import domain.enums.Proficiencias;
import repositories.BaseRepository;

public class DisciplinaService {

    private BaseRepository<Disciplina> repository;

    public DisciplinaService(BaseRepository<Disciplina> repository) {
        this.repository = repository;
    }

    public Disciplina registrarDisciplina(String nome, Proficiencias proficiencia) {
        Disciplina disciplina = new Disciplina(nome, proficiencia);
        return this.repository.save(disciplina);
    }

    public BaseRepository<Disciplina> getRepository() {
        return repository;
    }
}
