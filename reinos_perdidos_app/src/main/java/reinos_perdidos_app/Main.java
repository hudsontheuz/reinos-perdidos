package reinos_perdidos_app;

import reinos_perdidos_app.database.DatabaseConnection;
import reinos_perdidos_app.entities.Arquetipos;
import reinos_perdidos_app.entities.Batalha;
import reinos_perdidos_app.entities.Personagem;
import reinos_perdidos_app.entities.Raca;
import reinos_perdidos_app.repositories.ArquetipoRepository;
import reinos_perdidos_app.repositories.BatalhaRepository;
import reinos_perdidos_app.repositories.PersonagemRepository;
import reinos_perdidos_app.repositories.RacaRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
    	
    	Connection connection = DatabaseConnection.conectar();
    	
    	try {
            // Configure a conexão com o banco de dados
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reinos_perdidos", "root", "Famoso3capa");
            

    	// Inicializa os repositórios com a conexão estabelecida
            RacaRepository racaRepo = new RacaRepository(conn);
            ArquetipoRepository arquetipoRepo = new ArquetipoRepository(conn, conn);
            PersonagemRepository personagemRepo = new PersonagemRepository(conn);
            BatalhaRepository batalhaRepo = new BatalhaRepository(conn, conn);

            // Criação das raças e salvamento no banco
            Raca elfo = new Raca(0, "Elfo", 10, 5, 2, 8);
            Raca orc = new Raca(0, "Orc", 15, 10, 8, 2);
            Raca humano = new Raca(0, "Humano", 12, 7, 5, 5);

            racaRepo.save(elfo);
            racaRepo.save(orc);
            racaRepo.save(humano);

            // Criação dos arquétipos e salvamento no banco
            Arquetipos guerreiro = new Arquetipos(0, "Guerreiro", 20, 10, 7, 3);
            Arquetipos arqueiro = new Arquetipos(0, "Arqueiro", 10, 5, 3, 10);
            Arquetipos mago = new Arquetipos(0, "Mago", 8, 3, 2, 15);

            arquetipoRepo.save(guerreiro);
            arquetipoRepo.save(arqueiro);
            arquetipoRepo.save(mago);

            // Criação dos personagens e salvamento no banco
            Personagem Artemis = new Personagem(0, "Legolas", 100, 50, 15, 10, elfo, arqueiro);
            Personagem Ragnar = new Personagem(0, "Grom", 120, 80, 20, 5, orc, guerreiro);
            Personagem Gandalf = new Personagem(0, "Merlin", 80, 40, 5, 20, humano, mago);

            personagemRepo.save(Artemis);
            personagemRepo.save(Ragnar);
            personagemRepo.save(Gandalf);

            // Batalhas e salvamento no banco
            Batalha batalha1 = new Batalha(0, Artemis, Ragnar, Gandalf);
            batalha1.iniciar();
            batalhaRepo.save(batalha1);

            Batalha batalha2 = new Batalha(0, Artemis, Gandalf, Gandalf);
            batalha2.iniciar();
            batalhaRepo.save(batalha2);

            Batalha batalha3 = new Batalha(0, Ragnar, Gandalf, Gandalf);
            batalha3.iniciar();
            batalhaRepo.save(batalha3);

            // Exibe os registros salvos
            System.out.println("Raças salvas: " + racaRepo.findAll());
            System.out.println("Arquétipos salvos: " + arquetipoRepo.findAll());
            System.out.println("Personagens salvos: " + personagemRepo.findAll());
            System.out.println("Batalhas registradas: " + batalhaRepo.findAll());

            // Fecha a conexão com o banco de dados
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}