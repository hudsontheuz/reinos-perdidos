package reinos_perdidos_app.repositories;

import reinos_perdidos_app.entities.Personagem;
import reinos_perdidos_app.entities.Raca;
import reinos_perdidos_app.entities.Arquetipos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagemRepository {

    private Connection conn;

    public PersonagemRepository(Connection conn) {
        this.conn = conn;
    }

    public void save(Personagem personagem) throws SQLException {
        String sql = "INSERT INTO personagem (nome, vida, escudo, poder_fisico, poder_habilidade, raca_id, arquetipos_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, personagem.getNome());
            stmt.setInt(2, personagem.getVida());
            stmt.setInt(3, personagem.getEscudo());
            stmt.setInt(4, personagem.getPoderFisico());
            stmt.setInt(5, personagem.getPoderHabilidade());
            stmt.setInt(6, personagem.getRaca() != null ? personagem.getRaca().getId() : null);
            stmt.setInt(7, personagem.getArquetipo() != null ? personagem.getArquetipo().getId() : null);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                personagem.setId(rs.getInt(1));
            }
        }
    }

    public Personagem findById(int id) throws SQLException {
        String sql = "SELECT * FROM personagem WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Raca raca = new RacaRepository(conn).findById(rs.getInt("raca_id"));
                Arquetipos arquetipo = new ArquetipoRepository(conn, conn).findById(rs.getInt("arquetipos_id"));
                return new Personagem(rs.getInt("id"), rs.getString("nome"), rs.getInt("vida"), rs.getInt("escudo"), rs.getInt("poder_fisico"), rs.getInt("poder_habilidade"), raca, arquetipo);
            }
        }
        return null;
    }

    public List<Personagem> findAll() throws SQLException {
        List<Personagem> personagens = new ArrayList<>();
        String sql = "SELECT * FROM personagem";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Raca raca = new RacaRepository(conn).findById(rs.getInt("raca_id"));
                Arquetipos arquetipo = new ArquetipoRepository(conn, conn).findById(rs.getInt("arquetipos_id"));
                Personagem personagem = new Personagem(rs.getInt("id"), rs.getString("nome"), rs.getInt("vida"), rs.getInt("escudo"), rs.getInt("poder_fisico"), rs.getInt("poder_habilidade"), raca, arquetipo);
                personagens.add(personagem);
            }
        }
        return personagens;
    }

    public void update(Personagem personagem) throws SQLException {
        String sql = "UPDATE personagem SET nome = ?, vida = ?, escudo = ?, poder_fisico = ?, poder_habilidade = ?, raca_id = ?, arquetipos_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, personagem.getNome());
            stmt.setInt(2, personagem.getVida());
            stmt.setInt(3, personagem.getEscudo());
            stmt.setInt(4, personagem.getPoderFisico());
            stmt.setInt(5, personagem.getPoderHabilidade());
            stmt.setInt(6, personagem.getRaca() != null ? personagem.getRaca().getId() : null);
            stmt.setInt(7, personagem.getArquetipo() != null ? personagem.getArquetipo().getId() : null);
            stmt.setInt(8, personagem.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM personagem WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
