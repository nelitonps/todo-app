package com.npsouza.todo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity //Informa que esta classe representa uma entidade e que os seus objetos devem ser persistidos na base de dados
public class Todo implements Serializable {
    //Serializable para que toda vez que um objeto desta classe for instanciado ele possa ser convertido em uma sequencia de bites para que possa trafegar em redes, recuperado em memoria etc...
    private static final long serialVersionUID = 1l;

    @Id //Para informar que o id sera uma chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que o banco de dados gere as chaves automaticamente
    private Integer id;
    private String titulo;
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataFinalizar;
    private Boolean finalizada = false;

    public Todo() {
        super();
    }

    public Todo(Integer id, String titulo, String descricao, Date dataFinalizar, Boolean finalizada) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataFinalizar = dataFinalizar;
        this.finalizada = finalizada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataFinalizar() {
        return dataFinalizar;
    }

    public void setDataFinalizar(Date dataFinalizar) {
        this.dataFinalizar = dataFinalizar;
    }

    public Boolean getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
