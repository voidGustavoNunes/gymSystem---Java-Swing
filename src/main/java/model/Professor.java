/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Gustavo
 */
@Entity
//@PrimaryKeyJoinColumn(name="idProfessor")
public class Professor extends Pessoa implements Serializable {

    @Column(nullable = false)
    String situacao;

    @Column(nullable = false)
    String numeroRegistro;


    boolean usuarioMaster;

    String formacao;


    String instagram;

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @ManyToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinTable(name = "Professor_Aulas",
            joinColumns = {
                @JoinColumn(name = "idProfessor")},
            inverseJoinColumns = {
                @JoinColumn(name = "idAula")}
    )
    private List<Aulas> aulas = new ArrayList();

    @OneToMany(mappedBy = "chavePK.professor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AlunoProfessorExercicio> atividades;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public boolean isUsuarioMaster() {
        return usuarioMaster;
    }

    public void setUsuarioMaster(boolean usuarioMaster) {
        this.usuarioMaster = usuarioMaster;
    }

    public List<Aulas> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aulas> aulas) {
        this.aulas = aulas;
    }

    public List<AlunoProfessorExercicio> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<AlunoProfessorExercicio> atividades) {
        this.atividades = atividades;
    }

    public Professor() {
    }

    public Professor(String situacao, String numeroRegistro, boolean usuarioMaster, String nome, String cpf, Date dtNascimento, String endereco, String telefone, String bairro, char genero, String cidade, String observacao, byte[] foto, Date dtCadastro, String senha, int id, int numero, String formacao, String instagram) {
        super(nome, cpf, dtNascimento, endereco, telefone, bairro, genero, cidade, observacao, foto, dtCadastro, senha, id, situacao, numero);
        this.situacao = situacao;
        this.numeroRegistro = numeroRegistro;
        this.usuarioMaster = usuarioMaster;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}
