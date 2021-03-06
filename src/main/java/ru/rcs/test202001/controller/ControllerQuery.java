package ru.rcs.test202001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rcs.test202001.entity.Data;
import ru.rcs.test202001.entity.ParameterQuery;
import ru.rcs.test202001.services.ServiceDatabaseQuery;

import java.util.List;

@RestController
public class ControllerQuery {

    @Autowired
    ServiceDatabaseQuery serviceDatabaseQuery;

    @GetMapping("/")
    public List<Data> query(@RequestParam(value = "row") ParameterQuery row, @RequestParam(value = "col") ParameterQuery col) throws Exception {

        return serviceDatabaseQuery.getQuery(row, col);
    }

}