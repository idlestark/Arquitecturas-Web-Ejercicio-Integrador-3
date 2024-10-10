package org.example;
import DTO.CarreraDTO;
import DTO.EstudianteDTO;
import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import entities.EstudianteCarreraPK;
import factory.AbstractFactory;
import org.springframework.boot.SpringApplication;
import utils.HelperMySQL;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        SpringApplication.run(Main.class, args);

    }

}

