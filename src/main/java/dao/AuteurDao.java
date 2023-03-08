package dao;

import models.Auteur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuteurDao {

    private Connection connection;

    public AuteurDao(Connection connection) {
        this.connection = connection;
    }

    public List<Auteur> getAuteurs() throws SQLException {
        String selectAuteurs = "SELECT * FROM Auteur";
        List<Auteur> auteurs = new ArrayList<>();

        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectAuteurs);
        while (resultSet.next()) {
            auteurs.add(new Auteur(resultSet.getInt("IdAuteur"), resultSet.getString("nomPlume")));
        }

        return auteurs;
    }
}
