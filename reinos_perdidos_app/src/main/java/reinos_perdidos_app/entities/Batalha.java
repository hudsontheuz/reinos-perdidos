package reinos_perdidos_app.entities;

public class Batalha {
    private int id;
    private Personagem personagem1;
    private Personagem personagem2;
    private Personagem vencedor;

    public Batalha(int i, Personagem personagem1, Personagem personagem2, Personagem vencedor2) {
        this.personagem1 = personagem1;
        this.personagem2 = personagem2;
    }

    public void iniciar() {
        // Exemplo simples de lógica de batalha com base no poder físico e habilidade
        int poderPersonagem1 = personagem1.getPoderFisico() + personagem1.getPoderHabilidade();
        int poderPersonagem2 = personagem2.getPoderFisico() + personagem2.getPoderHabilidade();

        if (poderPersonagem1 > poderPersonagem2) {
            vencedor = personagem1;
        } else if (poderPersonagem2 > poderPersonagem1) {
            vencedor = personagem2;
        } else {
            // Critério de desempate: vencedor aleatório em caso de empate
            vencedor = Math.random() > 0.5 ? personagem1 : personagem2;
        }

        System.out.println("O vencedor da batalha entre " + personagem1.getNome() + " e " + personagem2.getNome() + " é " + vencedor.getNome());
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personagem getPersonagem1() {
        return personagem1;
    }

    public void setPersonagem1(Personagem personagem1) {
        this.personagem1 = personagem1;
    }

    public Personagem getPersonagem2() {
        return personagem2;
    }

    public void setPersonagem2(Personagem personagem2) {
        this.personagem2 = personagem2;
    }

    public Personagem getVencedor() {
        return vencedor;
    }

    public void setVencedor(Personagem vencedor) {
        this.vencedor = vencedor;
    }
}
