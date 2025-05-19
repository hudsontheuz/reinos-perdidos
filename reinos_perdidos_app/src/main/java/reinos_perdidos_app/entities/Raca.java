package reinos_perdidos_app.entities;

public class Raca {

    private Integer id;
    private String nome;
    private int bonusVida;
    private int bonusEscudo;
    private int bonusPoderFisico;
    private int bonusPoderHabilidade;


    public Raca(Integer id, String nome, int bonusVida, int bonusEscudo, int bonusPoderFisico, int bonusPoderHabilidade) {
        this.id = id;
        this.nome = nome;
        this.bonusVida = bonusVida;
        this.bonusEscudo = bonusEscudo;
        this.bonusPoderFisico = bonusPoderFisico;
        this.bonusPoderHabilidade = bonusPoderHabilidade;
    }

    // Getters e setters
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
}


 
