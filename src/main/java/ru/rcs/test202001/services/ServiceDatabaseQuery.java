package ru.rcs.test202001.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rcs.test202001.entity.Data;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Service
public class ServiceDatabaseQuery  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Data> getQuery(String row, String col) throws Exception {
        return jdbcTemplate.query("SELECT " + row+ ", " + col + ", count(" + col + ") AS val FROM source_data group by " + col,
                (resultSet, rowNum) -> new Data(resultSet.getString(row),
                        resultSet.getString(col),
                        resultSet.getLong("val")));
    }
}
