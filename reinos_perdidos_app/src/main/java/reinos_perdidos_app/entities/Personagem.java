package reinos_perdidos_app.entities;

public class Personagem {

    private Integer id;
    private String nome;
    private int vida;
    private int escudo;
    private int poderFisico;
    private int poderHabilidade;
    private Raca raca;
    private Arquetipos arquetipo;

    public Personagem(Integer id, String nome, int vida, int escudo, int poderFisico, int poderHabilidade, Raca raca, Arquetipos arquetipo) {
        this.id = id;
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
        this.poderFisico = poderFisico;
        this.poderHabilidade = poderHabilidade;
        this.raca = raca;
        this.arquetipo = arquetipo;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public int getPoderFisico() {
        return poderFisico;
    }

    public void setPoderFisico(int poderFisico) {
        this.poderFisico = poderFisico;
    }

    public int getPoderHabilidade() {
        return poderHabilidade;
    }

    public void setPoderHabilidade(int poderHabilidade) {
        this.poderHabilidade = poderHabilidade;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public Arquetipos getArquetipo() {
        return arquetipo;
    }

    public void setArquetipo(Arquetipos arquetipo) {
        this.arquetipo = arquetipo;
    }
}
