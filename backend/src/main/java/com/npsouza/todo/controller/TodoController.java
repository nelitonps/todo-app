package com.npsouza.todo.controller;

import com.npsouza.todo.domain.Todo;
import com.npsouza.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*") //Para dizer que podemos receber requisições de multiplas fontes
@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id){
        Todo obj = service.findById(id); //Chamando o metodo da classe TodoService injetado
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/open") //Buscar todos os Todos abertos
    public ResponseEntity<List<Todo>> listOpen(){
        List<Todo> list = service.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/close") //Buscar todos os Todos abertos
    public ResponseEntity<List<Todo>> listClose(){
        List<Todo> list = service.findAllClose();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping //Buscar todos os elementos
    public ResponseEntity<List<Todo>> listAll(){
        List<Todo> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping //Criar elementos
    public ResponseEntity<Todo> create(@RequestBody Todo obj){
        obj = service.createElemento(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}") //Alterar elementos
    public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj){
        Todo newObj = service.updateElemento(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}") //Deletar elementos
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deleteElemento(id);
        return ResponseEntity.noContent().build();
    }

}
