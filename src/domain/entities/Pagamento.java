package domain.entities;

import domain.enums.Credor;
import domain.enums.TipoPagemento;

public class Pagamento extends Entity {

    private TipoPagemento tipo;
    private Credor credor;
    private double valor;
    private String nome;

    public TipoPagemento getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagemento tipo) {
        this.tipo = tipo;
    }

    public Credor getCredor() {
        return credor;
    }

    public void setCredor(Credor credor) {
        this.credor = credor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pagamento(TipoPagemento tipo, Credor credor, double valor, String nome) {
        this.tipo = tipo;
        this.credor = credor;
        this.valor = valor;
        this.nome = nome;
    }

    public Pagamento(Credor credor, double valor) {
        this.credor = credor;
        this.valor = valor;
    }
}
