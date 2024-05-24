package com.hstn.crud;

import com.hstn.crud.dao.PupilDAO;
import com.hstn.crud.entity.Pupil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {

        SpringApplication.run(CrudApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(PupilDAO pupilDAO) {
        return runner -> {
//            createPupil(pupilDAO);
//            readPupilInfo(pupilDAO);

            getAllPupils(pupilDAO);

        };
    }

    private void getAllPupils(PupilDAO pupilDAO) {
        System.out.println("List of all pupils ...");
        List<Pupil> pupils = pupilDAO.findAll();
        for (var p : pupils) {
            System.out.println(p);
        }

    }

    private void readPupilInfo(PupilDAO pupilDAO) {

        System.out.println("Read pupil info ...");
        Pupil pupil = pupilDAO.findById(1);
        System.out.println("Pupil info from in DB: \n\t" + pupil);

    }

    private void createPupil(PupilDAO pupilDAO) {
        System.out.println("Creating new pupil ...");
        Pupil pupil = new Pupil("Oleg", "Petrov", "petrov@gmail.com");
        System.out.println("Saving pupil in DB ...");
        pupilDAO.save(pupil);
        System.out.println("Pupil in DB: \n\t" + pupil);

    }
}
