package ru.rcs.test202001.services;

import org.springframework.stereotype.Service;
import org.sqlite.JDBC;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ServiceDatabaseConnect {

    private  String dirPath = "/usr/local/lib/dataset/data.sqlite";
    private  File file = new File(dirPath);
    private final String CON_STR = "jdbc:sqlite:"+file.getAbsolutePath();

    private Connection connection;

    public ServiceDatabaseConnect() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);       
    }

    public Connection getConnection() {
        return connection;
    }


}
