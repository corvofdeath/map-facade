package bussiness.administrativo;

import domain.entities.Compromisso;
import domain.enums.Compromissos;
import domain.enums.Setores;
import repositories.BaseRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {

    private BaseRepository<Compromisso> repository;

    public Agenda(BaseRepository<Compromisso> repository) {
        this.repository = repository;
    }

    public Compromisso criarCompromisso(Date data, Setores setor, Compromissos tipo) {
        Compromisso novo = new Compromisso(data, tipo, setor);
        this.repository.save(novo);

        return novo;
    }

    public List<Compromisso> recuperarCompromissoPorSetor(Setores setor) {
        return this.repository.getAll().stream().filter(e -> e.getSetor().equals(setor)).collect(Collectors.toList());
    }

    public List<Compromisso> recuperarCompromissoPorTipo(Compromissos tipo) {
        return this.repository.getAll().stream().filter(e -> e.getCompromisso().equals(tipo)).collect(Collectors.toList());
    }

    public BaseRepository<Compromisso> getRepository() {
        return repository;
    }
}
