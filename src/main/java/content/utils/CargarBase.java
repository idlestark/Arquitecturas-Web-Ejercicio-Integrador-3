package content.utils;
import content.entities.*;
import content.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

@Configuration
@Slf4j
class CargarBase {

   @Bean
   CommandLineRunner initDatabase(@Qualifier("estudianteRepository") EstudianteRepository estudianteRepository,
                                  @Qualifier("carreraRepository") CarreraRepository carreraRepository,
                                  @Qualifier("estudianteCarreraRepository") EstudianteCarreraRepository estudianteCarreraRepository) {
      return args -> {

         //CREACIÓN Y CARGA DE CARRERAS
         Carrera tudai = new Carrera(1, "Tecnicatura Universitaria en Desarrollo de Aplicaciones Informáticas");
         Carrera tuari = new Carrera(2, "Tecnicatura Universitaria en Administración de Redes Informáticas");
         Carrera veterinaria = new Carrera(3, "Medicina Veterinaria");
         Carrera profesoradoInformatica = new Carrera(4, "Profesorado de Informática");
         Carrera turismo = new Carrera(5, "Turismo");
         Carrera profesoradoMatematica = new Carrera(6, "Profesorado de Matemática");

         carreraRepository.save(tudai);
         carreraRepository.save(tuari);
         carreraRepository.save(veterinaria);
         carreraRepository.save(profesoradoInformatica);
         carreraRepository.save(turismo);
         carreraRepository.save(profesoradoMatematica);

         //CREACIÓN Y CARGA DE ESTUDIANTES
         Estudiante es1 = new Estudiante(12345678L, "Giancarlo", "Espósito", "Masculino", 44, "Buenos Aires", 12345);
         Estudiante es2 = new Estudiante(87654321L, "Ignacio", "Ferrari", "Masculino", 40, "Rosario", 67890);
         Estudiante es3 = new Estudiante(25654324L, "Jorge", "Newbery", "Masculino", 25, "Tandil", 15258);
         Estudiante es4 = new Estudiante(45765980L, "Lucas", "Mondongo", "Masculino", 21, "Mar del Plata", 69420);
         Estudiante es5 = new Estudiante(87654321L, "Manuel", "Echeverría", "Masculino", 40, "Rosario", 67890);
         Estudiante es6 = new Estudiante(77654123L, "Josefina", "Schneider", "Femenino", 27, "Concordia", 88673);

         estudianteRepository.save(es1);
         estudianteRepository.save(es2);
         estudianteRepository.save(es3);
         estudianteRepository.save(es4);
         estudianteRepository.save(es5);
         estudianteRepository.save(es6);

         //CREACIÓN Y CARGA DE RELACIONES ESTUDIANTE-CARRERA
         EstudianteCarreraPK pk1 = new EstudianteCarreraPK(es1.getDni(), tudai.getIdCarrera());
         EstudianteCarrera estudianteCarrera1 = new EstudianteCarrera(pk1, es1, tudai, Date.valueOf("2024-05-10"), true);

         EstudianteCarreraPK pk2 = new EstudianteCarreraPK(es2.getDni(), tuari.getIdCarrera());
         EstudianteCarrera estudianteCarrera2 = new EstudianteCarrera(pk2, es2, tuari, Date.valueOf("2022-05-07"), false);

         EstudianteCarreraPK pk3 = new EstudianteCarreraPK(es3.getDni(), turismo.getIdCarrera());
         EstudianteCarrera estudianteCarrera3 = new EstudianteCarrera(pk3, es3, turismo, Date.valueOf("2020-02-28"), false);


         EstudianteCarreraPK pk4 = new EstudianteCarreraPK(es4.getDni(), turismo.getIdCarrera());
         EstudianteCarrera estudianteCarrera4 = new EstudianteCarrera(pk4, es4, turismo, Date.valueOf("2020-02-29"), true);

         EstudianteCarreraPK pk5 = new EstudianteCarreraPK(es5.getDni(), profesoradoMatematica.getIdCarrera());
         EstudianteCarrera estudianteCarrera5 = new EstudianteCarrera(pk5, es5, profesoradoMatematica, Date.valueOf("2020-03-25"), false);

         EstudianteCarreraPK pk6 = new EstudianteCarreraPK(es6.getDni(), profesoradoMatematica.getIdCarrera());
         EstudianteCarrera estudianteCarrera6 = new EstudianteCarrera(pk6, es6, profesoradoMatematica, Date.valueOf("2012-10-01"), true);


         estudianteCarreraRepository.save(estudianteCarrera1);
         estudianteCarreraRepository.save(estudianteCarrera2);
         estudianteCarreraRepository.save(estudianteCarrera3);
         estudianteCarreraRepository.save(estudianteCarrera4);
         estudianteCarreraRepository.save(estudianteCarrera5);
         estudianteCarreraRepository.save(estudianteCarrera6);
      };
   }
}
