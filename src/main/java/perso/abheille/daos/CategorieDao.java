package perso.abheille.daos;

import perso.abheille.pojos.Categorie;
import perso.abheille.pojos.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CategorieDao {

    public List<Categorie> getCategorieList() {

        String query = "SELECT categorie.idcategorie,categorie.nomcategorie FROM categorie";
        List<Categorie> listOfCategories = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listOfCategories.add(
                        new Categorie(
                                resultSet.getInt("idcategorie"),
                                resultSet.getString("nomcategorie"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCategories;
    }

    public void addCategorie(Categorie categorie) {
    }
}
