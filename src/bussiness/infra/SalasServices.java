package bussiness.infra;

import domain.entities.Disciplina;
import domain.entities.Professor;
import domain.entities.Sala;
import repositories.BaseRepository;

public class SalasServices {

    private BaseRepository<Sala> repository;

    
    public SalasServices(BaseRepository<Sala> repository) {
        this.repository = repository;
    }

    public Sala criarSala(String codigo) {
        Sala sala = new Sala(codigo);
        return this.repository.save(sala);
    }

    public Sala alocarSala(String codigo, Professor professor, Disciplina disciplina) {
        for (Sala sala : this.repository.getAll()) {
            if (sala.getCodigo().equals(codigo)) {
                sala.setProfessor(professor);
                sala.setDisciplina(disciplina);
            }

            return sala;
        }

        return null;
    }

    public BaseRepository<Sala> getRepository() {
        return repository;
    }
}
