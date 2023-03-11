package com.studenthousekeeping.training.Student;

import java.time.LocalDate;
import java.time.Month;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            if(repository.findStudentByEmail("mariam@info.com").isEmpty()){
            Student mariam = new Student(
                "Mariam",
                "Jamal",
                "Biology",
                "mariam@info.com",
                LocalDate.of(2000, Month.FEBRUARY, 9)
            );
            repository.save(mariam);
            }
            if(repository.findStudentByEmail("alex@info.com").isEmpty()) {
            Student alex = new Student(
                "Alex",
                "James",
                "Physics",
                "alex@info.com",
                LocalDate.of(2000, Month.FEBRUARY, 9)
            );
            repository.save(alex);
            }

            // repository.saveAll(
            //     List.of(mariam, alex)
            // );
        };
    }
    
}
