/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Gustavo
 */
@Entity
public class Turma implements Serializable{
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    int idTurma;
    
    @ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "idAula")
    private Aulas aulas;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="idTurma")
    private Horario horarios;
    
    
    @Column (name = "nomeTurma", nullable = false)
    String nome;
    
    @ManyToMany (fetch = FetchType.EAGER)//TERMINAR
    @JoinTable(name="Turma_Aluno",
              joinColumns={@JoinColumn(name="idTurma")},
              inverseJoinColumns={@JoinColumn(name="idAluno")}
               )
    List<Aluno> alunos =new ArrayList();


    public int getIdTurma() {
        return idTurma;
    }

    public Aulas getAulas() {
        return aulas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public void setAulas(Aulas aulas) {
        this.aulas = aulas;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Turma() {
    }

    public Turma(Aulas aulas, String nome, String segunda, String terca, String quarta, String quinta, String sexta, String sabado) {
        this.aulas = aulas;
        this.nome = nome;
        this.horarios = new Horario(segunda, terca, quarta, quinta, sexta, sabado);
        this.horarios.setTurma(this);
        //aulas.getTurmas().add(this);
        
    }

    public Horario getHorarios() {
        return horarios;
    }

    public void setHorarios(Horario horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        return nome;
    }



    

    
}
