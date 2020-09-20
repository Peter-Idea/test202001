package ru.rcs.test202001.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.rcs.test202001.entity.Data;
import ru.rcs.test202001.entity.ParameterQuery;

import java.util.List;

@Service
public class ServiceDatabaseQuery {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Data> getQuery(ParameterQuery parameterRow,
                               ParameterQuery parameterCol) {
        StringBuffer query = new StringBuffer("SELECT ");
        query.append(parameterRow).append(", ").append(parameterCol).append(", count(").append(parameterCol).append(") AS val FROM source_data group by ").append(parameterCol);
        return jdbcTemplate.query(query.toString(),
                (resultSet, rowNum) -> new Data(resultSet.getString(parameterRow.toString()),
                        resultSet.getString(parameterCol.toString()),
                        resultSet.getLong("val")));
    }
}
