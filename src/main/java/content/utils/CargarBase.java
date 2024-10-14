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
         log.info("Loading data into the database...");

         Carrera tudai = new Carrera(1, "Tecnicatura Universitaria en Desarrolo de Aplicaciones Informáticas");
         Carrera tuari = new Carrera(2, "Tecnicatura Universitaria en Administración de Redes Informáticas");
         Carrera vete = new Carrera(3, "Medicina Veterinaria");
         Carrera profesoradoInformatica = new Carrera(4, "Profesorado de Informática");

         log.info("Preloading " + carreraRepository.save(tudai));
         log.info("Preloading " + carreraRepository.save(tuari));
         log.info("Preloading " + carreraRepository.save(vete));
         log.info("Preloading " + carreraRepository.save(profesoradoInformatica));

         Estudiante es1 = new Estudiante(12345678L, "Carlos", "Pérez", "Masculino", 20, "Buenos Aires", 12345);
         Estudiante es2 = new Estudiante(87654321L, "Ana", "González", "Femenino", 40, "Rosario", 67890);

         log.info("Preloading " + estudianteRepository.save(es1));
         log.info("Preloading " + estudianteRepository.save(es2));

         EstudianteCarreraPK pk1 = new EstudianteCarreraPK(es1.getDni(), tudai.getIdCarrera());
         EstudianteCarrera estudianteCarrera1 = new EstudianteCarrera(pk1, es1, tudai, Date.valueOf("2024-05-10"), true);

         EstudianteCarreraPK pk2 = new EstudianteCarreraPK(es2.getDni(), tuari.getIdCarrera());
         EstudianteCarrera estudianteCarrera2 = new EstudianteCarrera(pk2, es2, tuari, Date.valueOf("2022-05-07"), false);

         log.info("Preloading " + estudianteCarreraRepository.save(estudianteCarrera1));
         log.info("Preloading " + estudianteCarreraRepository.save(estudianteCarrera2));
      };
   }
}
