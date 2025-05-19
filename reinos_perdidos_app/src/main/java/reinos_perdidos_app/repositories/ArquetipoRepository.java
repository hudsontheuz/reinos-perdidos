package reinos_perdidos_app.repositories;

import reinos_perdidos_app.entities.Arquetipos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArquetipoRepository {

    private Connection conn;

    public ArquetipoRepository(Connection conn2, Connection conn) {
        this.conn = conn;
    }

    public void save(Arquetipos arquetipo) throws SQLException {
        String sql = "INSERT INTO arquetipos (nome, bonus_poder_fisico, bonus_poder_habilidade, bonus_vida, bonus_escudo, atributos) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, arquetipo.getNome());
            stmt.setInt(2, arquetipo.getBonusPoderFisico());
            stmt.setInt(3, arquetipo.getBonusPoderHabilidade());
            stmt.setInt(4, arquetipo.getBonusVida());
            stmt.setInt(5, arquetipo.getBonusEscudo());
            stmt.setInt(6, arquetipo.getAtributos());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                arquetipo.setId(rs.getInt(1));
            }
        }
    }

    public Arquetipos findById(int id) throws SQLException {
        String sql = "SELECT * FROM arquetipos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Arquetipos(rs.getInt("id"), rs.getString("nome"), rs.getInt("bonus_poder_fisico"), rs.getInt("bonus_poder_habilidade"), rs.getInt("bonus_vida"), rs.getInt("bonus_escudo"));
            }
        }
        return null;
    }

    public List<Arquetipos> findAll() throws SQLException {
        List<Arquetipos> arquetipos = new ArrayList<>();
        String sql = "SELECT * FROM arquetipos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Arquetipos arquetipo = new Arquetipos(rs.getInt("id"), rs.getString("nome"), rs.getInt("bonus_poder_fisico"), rs.getInt("bonus_poder_habilidade"), rs.getInt("bonus_vida"), rs.getInt("bonus_escudo"));
                arquetipos.add(arquetipo);
            }
        }
        return arquetipos;
    }

    public void update(Arquetipos arquetipo) throws SQLException {
        String sql = "UPDATE arquetipos SET nome = ?, bonus_poder_fisico = ?, bonus_poder_habilidade = ?, bonus_vida = ?, bonus_escudo = ?, atributos = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, arquetipo.getNome());
            stmt.setInt(2, arquetipo.getBonusPoderFisico());
            stmt.setInt(3, arquetipo.getBonusPoderHabilidade());
            stmt.setInt(4, arquetipo.getBonusVida());
            stmt.setInt(5, arquetipo.getBonusEscudo());
            stmt.setInt(6, arquetipo.getAtributos());
            stmt.setInt(7, arquetipo.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM arquetipos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
