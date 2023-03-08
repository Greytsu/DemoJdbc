import dao.AuteurDao;
import models.Auteur;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Database database = new Database("jdbc:mysql://localhost:3325/", "biblio", "root", "olivier");

            AuteurDao auteurDao = new AuteurDao(database.getConnection());

            List<Auteur> auteurs = auteurDao.getAuteurs();

            for (Auteur auteur : auteurs){
                System.out.print(auteur.getId());
                System.out.print(" ");
                System.out.println(auteur.getNom());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
