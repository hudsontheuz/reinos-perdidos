package reinos_perdidos_app.repositories;

import reinos_perdidos_app.entities.Raca;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RacaRepository {

    private Connection conn;

    public RacaRepository(Connection conn) {
        this.conn = conn;
    }

    public void save(Raca raca) throws SQLException {
        String sql = "INSERT INTO raca (nome, bonus_vida, bonus_escudo, bonus_poder_fisico, bonus_poder_habilidade) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, raca.getNome());
            stmt.setInt(2, raca.getBonusVida());
            stmt.setInt(3, raca.getBonusEscudo());
            stmt.setInt(4, raca.getBonusPoderFisico());
            stmt.setInt(5, raca.getBonusPoderHabilidade());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                raca.setId(rs.getInt(1));
            }
        }
    }

    public Raca findById(int id) throws SQLException {
        String sql = "SELECT * FROM raca WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Raca(rs.getInt("id"), rs.getString("nome"), rs.getInt("bonus_vida"), rs.getInt("bonus_escudo"), rs.getInt("bonus_poder_fisico"), rs.getInt("bonus_poder_habilidade"));
            }
        }
        return null;
    }

    public List<Raca> findAll() throws SQLException {
        List<Raca> racas = new ArrayList<>();
        String sql = "SELECT * FROM raca";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Raca raca = new Raca(rs.getInt("id"), rs.getString("nome"), rs.getInt("bonus_vida"), rs.getInt("bonus_escudo"), rs.getInt("bonus_poder_fisico"), rs.getInt("bonus_poder_habilidade"));
                racas.add(raca);
            }
        }
        return racas;
    }

    public void update(Raca raca) throws SQLException {
        String sql = "UPDATE raca SET nome = ?, bonus_vida = ?, bonus_escudo = ?, bonus_poder_fisico = ?, bonus_poder_habilidade = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, raca.getNome());
            stmt.setInt(2, raca.getBonusVida());
            stmt.setInt(3, raca.getBonusEscudo());
            stmt.setInt(4, raca.getBonusPoderFisico());
            stmt.setInt(5, raca.getBonusPoderHabilidade());
            stmt.setInt(6, raca.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM raca WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
