/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Gustavo
 */
@Entity
public class Aulas implements Serializable{
    
    String tipo;
    

    @ManyToMany (fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @JoinTable(name="Professor_Aulas",
              joinColumns={@JoinColumn(name="idAula")},
              inverseJoinColumns={@JoinColumn(name="idProfessor")}
               )
    List<Professor> professores = new ArrayList();
    
    
    @OneToMany(mappedBy="aulas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Turma> turmas = new ArrayList();

        
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    int idAula;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public Aulas(String tipo, int idAula) {
        this.tipo = tipo;
        this.idAula = idAula;
        this.turmas = turmas;
    }

    
    public Aulas() {
    }

    @Override
    public String toString() {
        return this.getTipo();
    }
    
    
    
}
