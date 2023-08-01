import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Todo } from 'src/app/models/todo';
import { TodoService } from 'src/app/services/todo.service';
import { Injectable } from '@angular/core';


@Component({
  selector: 'app-finalizados',
  templateUrl: './finalizados.component.html',
  styleUrls: ['./finalizados.component.css']
})
export class FinalizadosComponent implements OnInit{

  listFinished: Todo[] = [];


  constructor(private service: TodoService, private router: Router){}

  ngOnInit(): void {
    this.findAll();
    
  }

  findAll(): void{
    //Serviço que vai fazer as requisições do BACKEND
    this.service.findAll().subscribe((resposta) => {
      resposta.forEach(todo => {
        if(todo.finalizada){
          this.listFinished.push(todo);
        }
      })
      
    })
  }

  voltar(): void{
    this.router.navigate([''])
  }

}
