package reinos_perdidos_app.entities;

public class Arquetipos {

    private Integer id;
    private String nome;
    private int bonusPoderFisico;
    private int bonusPoderHabilidade;
    private int bonusVida;
    private int bonusEscudo;
    private int atributos;

    public Arquetipos(int id, String nome, int bonusPoderFisico, int bonusPoderHabilidade, int bonusVida, int bonusEscudo) {
        this.id = id;
        this.nome = nome;
        this.bonusPoderFisico = bonusPoderFisico;
        this.bonusPoderHabilidade = bonusPoderHabilidade;
        this.bonusVida = bonusVida;
        this.bonusEscudo = bonusEscudo;
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

    public int getBonusPoderFisico() {
        return bonusPoderFisico;
    }

    public void setBonusPoderFisico(int bonusPoderFisico) {
        this.bonusPoderFisico = bonusPoderFisico;
    }

    public int getBonusPoderHabilidade() {
        return bonusPoderHabilidade;
    }

    public void setBonusPoderHabilidade(int bonusPoderHabilidade) {
        this.bonusPoderHabilidade = bonusPoderHabilidade;
    }

    public int getBonusVida() {
        return bonusVida;
    }

    public void setBonusVida(int bonusVida) {
        this.bonusVida = bonusVida;
    }

    public int getBonusEscudo() {
        return bonusEscudo;
    }

    public void setBonusEscudo(int bonusEscudo) {
        this.bonusEscudo = bonusEscudo;
    }

    public int getAtributos() {
        return atributos;
    }

    public void setAtributos(int atributos) {
        this.atributos = atributos;
    }
}
