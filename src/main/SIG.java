package main;

import bussiness.administrativo.Agenda;
import bussiness.almoxarifado.Estoque;
import bussiness.alunos.AlunoService;
import bussiness.disciplinas.DisciplinaService;
import bussiness.financeiro.Balanco;
import bussiness.infra.SalasServices;
import bussiness.professores.ProfessorService;
import domain.entities.*;
import domain.enums.Compromissos;
import domain.enums.Proficiencias;
import domain.enums.Setores;
import repositories.BaseRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SIG {

    private final Agenda agenda;
    private final Estoque estoque;
    private final Balanco balanco;
    private final AlunoService alunoService;
    private final DisciplinaService disciplinaService;
    private final ProfessorService professorService;
    private final SalasServices salasServices;

    public SIG() {
        this.agenda = new Agenda(new BaseRepository<>(new ArrayList<>()));
        this.estoque = new Estoque(new BaseRepository<>(new ArrayList<>()), new BaseRepository<>(new ArrayList<>()));
        this.balanco = new Balanco(new BaseRepository<>(new ArrayList<>()));
        this.alunoService = new AlunoService(new BaseRepository<>(new ArrayList<>()));
        this.disciplinaService = new DisciplinaService(new BaseRepository<>(new ArrayList<>()));
        this.professorService = new ProfessorService(new BaseRepository<>(new ArrayList<>()));
        this.salasServices = new SalasServices(new BaseRepository<>(new ArrayList<>()));
    }

    public Aluno registrarAluno(String nome) {
        return this.alunoService.registrarAluno(nome);
    }

    public Professor registrarProfessor(String nome, Proficiencias proficiencia, double salario) {
        return this.professorService.matricularProfessor(nome, proficiencia, salario);
    }

    public Disciplina criarDisciplina(String nome, Proficiencias proficiencia) {
        return this.disciplinaService.registrarDisciplina(nome, proficiencia);
    }

    public Compromisso agendarCompromisso(Date data, Setores setor, Compromissos tipo) {
        return this.agenda.criarCompromisso(data, setor, tipo);
    }

    public List<Compromisso> listarCompromissos() {
        return this.agenda.getRepository().getAll();
    }

    public List<Compromisso> listarCompromissosPorSetor(Setores setor) {
        return this.agenda.recuperarCompromissoPorSetor(setor);
    }

    public List<Compromisso> listarCompromissosPorTipo(Compromissos tipo) {
        return this.agenda.recuperarCompromissoPorTipo(tipo);
    }

    public double gerarBalanco() {
        return this.balanco.gerarBalancoSemPedidos();
    }

    public double gerarBalancoCompleto() {
        return this.balanco.gerarBalnacoComPedidos(this.estoque.recuperarPedidosAbertos());
    }

    public List<Pagamento> gerarFolhaDePagamento() {
        return this.balanco.gerarFolhaDePagamento(this.professorService.getRepository().getAll());
    }

    public long calcularTempoDeCasaParaProfessor(Professor professor) {
        return this.professorService.calcularTempoDeCasa(professor);
    }

    public Sala alocarProfessorDisponivelPorDisciplina(Sala sala, Disciplina disciplina) {
        Professor professor = this.professorService.procurarProfessorDisponivelPorProficiencia(disciplina.getProficiencia());
        sala.setDisciplina(disciplina);
        sala.setProfessor(professor);
        professor.setAlocado(true);

        return sala;
    }

    public Matricula matricularNaDisciplina(Sala sala, Aluno aluno) {
        return this.alunoService.matricularAlunoNaDisciplina(sala, aluno);
    }

    public Aluno finalizarSemestre(Aluno aluno) {
        return this.alunoService.finalizarSemestre(aluno);
    }

    public Pedido realizarPedido(String nome, int quantidade, double valor) {
        return this.estoque.gerarPedido(nome, quantidade, valor);
    }

    public Item adicionarItemAoEstoque(String nome, int quantidade) {
        return this.estoque.adicionarItemAoEstoque(nome, quantidade);
    }

    public Sala criarSala(String codigo) {
        return this.salasServices.criarSala(codigo);
    }

    public Sala alocarSala(String codigo, Disciplina disciplina, Professor professor) {
        return this.salasServices.alocarSala(codigo, professor, disciplina);
    }
}
