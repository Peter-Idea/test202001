package ru.rcs.test202001.services;

import org.springframework.stereotype.Service;
import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ServiceDatabaseConnect {

    private static final String CON_STR = "jdbc:sqlite:dataset/data.sqlite";

    private Connection connection;

    public ServiceDatabaseConnect() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public Connection getConnection() {
        return connection;
    }


}