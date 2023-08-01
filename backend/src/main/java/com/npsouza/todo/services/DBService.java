package com.npsouza.todo.services;

import com.npsouza.todo.domain.Todo;
import com.npsouza.todo.repositories.ITodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

//@Service
public class DBService {

//   @Autowired
//    private ITodoRepository todoRepository;

    //Para identificar que este método vai ser iniciado sempre que uma nova instancia for iniciada é preciso usar @Bean para usar a inicialização em classes fora da classe principal TodoApplication
    @Bean
    public void instanciaBaseDados() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Todo t1 = new Todo(null, "Estudar", "Spring Boot 2 e Angular", sdf.parse("25/03/2022"), false);
        Todo t2 = new Todo(null, "Ler", "Livro o Segredo", sdf.parse("22/10/2022"), true);
        Todo t3 = new Todo(null, "Exercicios", "Fazer academia", sdf.parse("21/10/2022"), false);
        Todo t4 = new Todo(null, "Meditar", "Diariamente 30 minutos", sdf.parse("27/10/2022"), true);

//      todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));

    }

}
