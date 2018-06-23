package perso.abheille.daos;

import perso.abheille.pojos.Article;
import perso.abheille.pojos.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TagDao {

    public List<Tag> getTagList() {

        String query = "SELECT tag.idtag,tag.tagname FROM tag";
        List<Tag> listOfTag = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listOfTag.add(
                        new Tag(
                                resultSet.getInt("idtag"),
                                resultSet.getString("tagname")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfTag;
    }
}

