package reinos_perdidos_app.entities;

public class Lutador {
    private String nome;
    private int vida;
    private int escudo;
    private int poderFisico;
    private int poderHabilidade;

    public Lutador(String nome, int vida, int escudo, int poderFisico, int poderHabilidade) {
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
        this.poderFisico = poderFisico;
        this.poderHabilidade = poderHabilidade;
    }

    public void ataca(Lutador alvo) {
        int dano = poderFisico + poderHabilidade;
        alvo.defende(dano);
    }

    public void defende(int dano) {
        int danoFinal = dano - escudo;
        if (danoFinal > 0) {
            vida -= danoFinal;
        }
        if (vida < 0) {
            vida = 0;
        }
    }

    public boolean isVivo() {
        return vida > 0;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public void setPoderFisico(int poderFisico) {
        this.poderFisico = poderFisico;
    }

    public void setPoderHabilidade(int poderHabilidade) {
        this.poderHabilidade = poderHabilidade;
    }
    
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getEscudo() {
        return escudo;
    }

    public int getPoderFisico() {
        return poderFisico;
    }

    public int getPoderHabilidade() {
        return poderHabilidade;
    }

    protected int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}