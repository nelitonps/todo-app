package com.npsouza.todo.services;

import com.npsouza.todo.domain.Todo;
import com.npsouza.todo.repositories.ITodoRepository;
import com.npsouza.todo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private ITodoRepository repository;

    public Todo findById(Integer id){
        //Fazendo a busca do Todo na base de dados
        Optional<Todo> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado Id: " + id + " / Tipo: " + Todo.class.getName())); //Se não encontrar retorna null se encontrar retorna o objeto Todo
    }

    //Metodo para listar os todos abertos
    public List<Todo> findAllOpen() {
        List<Todo> list = repository.findAllOpenRepository();
        return list;
    }

    public List<Todo> findAllClose() {
        List<Todo> list = repository.findAllCloseRepository();
        return list;
    }

    public List<Todo> findAll() {
        List<Todo> list = repository.findAll();
        return list;
    }

    public Todo createElemento(Todo obj) {
        obj.setId(null); //Por segurança para evitar que usuario informe o id
        return repository.save(obj);
    }

    public void deleteElemento(Integer id) {
        repository.deleteById(id);
    }

    public Todo updateElemento(Integer id, Todo obj) {
        Todo newObj = findById(id);
        newObj.setTitulo(obj.getTitulo());
        newObj.setDataFinalizar(obj.getDataFinalizar());
        newObj.setDescricao(obj.getDescricao());
        newObj.setFinalizada(obj.getFinalizada());
        return repository.save(newObj);
    }
}
