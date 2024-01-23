/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author Gustavo
 */
@Entity
public class AlunoProfessorExercicio implements Serializable{

    
    @EmbeddedId
    private AlunoEProfessorEExercicioPK chavePK;

    public AlunoEProfessorEExercicioPK getChavePK() {
        return chavePK;
    }

    public void setChavePK(AlunoEProfessorEExercicioPK chavePK) {
        this.chavePK = chavePK;
    }

    public AlunoProfessorExercicio(Professor prof, Aluno aluno, Exercicio ex) {
        this.chavePK = new AlunoEProfessorEExercicioPK(aluno, prof, ex);
    }    
    

    public AlunoProfessorExercicio(AlunoEProfessorEExercicioPK chavePK) {

        this.chavePK = chavePK;
    }

    public AlunoProfessorExercicio() {
    }
    
    
    
}
