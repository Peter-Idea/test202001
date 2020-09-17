package ru.rcs.test202001.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rcs.test202001.entity.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ServiceDatabaseQuery {

    @Autowired
    ServiceDatabaseConnect databaseConnect;


    public List<Data> getData(String row, String col) {

        try (Statement statement = databaseConnect.getConnection().createStatement()) {
            List<Data> strings = new ArrayList<Data>();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT " + row + ", " + col + ", count(" + col + ") AS val FROM source_data group by " + col);
            int columns = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                strings.add(new Data(resultSet.getString(row),
                        resultSet.getString(col),
                        resultSet.getLong("val")));
            }
            return strings;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
