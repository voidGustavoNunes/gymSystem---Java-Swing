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
import javax.persistence.OneToMany;
import javax.swing.JCheckBox;

/**
 *
 * @author Gustavo
 */
@Entity
public class Exercicio implements Serializable {
    
    @Column (name = "nomeExercicio", nullable = false)
    String nome;
    
    @Column(columnDefinition = "TEXT")
    String funcao;
    
    @Column
    int series;
    
    @Column
    int repeticoesPorSerie;
    
    @Column
    String idadeRecomendada;
    
    
    @Column
    String tipo;

    public void setId(int id) {
        this.id = id;
    }
    
    
    @OneToMany(mappedBy = "chavePK.exercicio", fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    private List<AlunoProfessorExercicio> atividades;
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "idExercicio")
    int id;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoesPorSerie() {
        return repeticoesPorSerie;
    }

    public void setRepeticoesPorSerie(int repeticoesPorSerie) {
        this.repeticoesPorSerie = repeticoesPorSerie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

    public void setFuncao(String  funcao) {
        this.funcao = funcao;
    }

    public String getIdadeRecomendada() {
        return idadeRecomendada;
    }

    public void setIdadeRecomendada(String idadeRecomendada) {
        this.idadeRecomendada = idadeRecomendada;
    }

    public int getId() {
        return id;
    }

    public List<AlunoProfessorExercicio> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<AlunoProfessorExercicio> atividades) {
        this.atividades = atividades;
    }

    public Exercicio() {
    }

    public Exercicio(String nome, String funcao, int series, int repeticoesPorSerie, String idadeRecomendada, String tipo) {
        this.nome = nome;
        this.funcao = funcao;
        this.idadeRecomendada = idadeRecomendada;
        this.atividades = atividades;
        this.series = series;
        this.repeticoesPorSerie = repeticoesPorSerie;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
