package com.npsouza.todo.repositories;

import com.npsouza.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Informar para o Spring que este vai ser o repositorio
@Repository
public interface ITodoRepository extends JpaRepository<Todo, Integer> { //Usar extends JpaRepository<classe, id(chave primaria)> para manipulação do banco de dados

    @Query("SELECT obj FROM Todo obj WHERE obj.finalizada = false ORDER BY obj.dataFinalizar")
    List<Todo> findAllOpenRepository();

    @Query("SELECT obj FROM Todo obj WHERE obj.finalizada = true ORDER BY obj.dataFinalizar")
    List<Todo> findAllCloseRepository();


}
