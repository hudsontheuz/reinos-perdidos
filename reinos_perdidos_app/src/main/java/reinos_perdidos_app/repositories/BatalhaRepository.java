package reinos_perdidos_app.repositories;

import reinos_perdidos_app.entities.Batalha;
import reinos_perdidos_app.entities.Personagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BatalhaRepository {

    private Connection conn;

    public BatalhaRepository(Connection conn2, Connection conn) {
        this.conn = conn;
    }

    public void save(Batalha batalha) throws SQLException {
        String sql = "INSERT INTO batalha (lutador1_id, lutador2_id, vencedor_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, batalha.getPersonagem1().getId());
            stmt.setInt(2, batalha.getPersonagem2().getId());
            stmt.setInt(3, batalha.getVencedor() != null ? batalha.getVencedor().getId() : null);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                batalha.setId(rs.getInt(1));
            }
        }
    }

    public Batalha findById(int id) throws SQLException {
        String sql = "SELECT * FROM batalha WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Personagem lutador1 = new PersonagemRepository(conn).findById(rs.getInt("lutador1_id"));
                Personagem lutador2 = new PersonagemRepository(conn).findById(rs.getInt("lutador2_id"));
                Personagem vencedor = new PersonagemRepository(conn).findById(rs.getInt("vencedor_id"));
                return new Batalha(rs.getInt("id"), lutador1, lutador2, vencedor);
            }
        }
        return null;
    }

    public List<Batalha> findAll() throws SQLException {
        List<Batalha> batalhas = new ArrayList<>();
        String sql = "SELECT * FROM batalha";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Personagem lutador1 = new PersonagemRepository(conn).findById(rs.getInt("lutador1_id"));
                Personagem lutador2 = new PersonagemRepository(conn).findById(rs.getInt("lutador2_id"));
                Personagem vencedor = new PersonagemRepository(conn).findById(rs.getInt("vencedor_id"));
                Batalha batalha = new Batalha(rs.getInt("id"), lutador1, lutador2, vencedor);
                batalhas.add(batalha);
            }
        }
        return batalhas;
    }

    public void update(Batalha batalha) throws SQLException {
        String sql = "UPDATE batalha SET lutador1_id = ?, lutador2_id = ?, vencedor_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, batalha.getPersonagem1().getId());
            stmt.setInt(2, batalha.getPersonagem2().getId());
            stmt.setInt(3, batalha.getVencedor() != null ? batalha.getVencedor().getId() : null);
            stmt.setInt(4, batalha.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM batalha WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
