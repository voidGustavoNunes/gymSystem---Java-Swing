/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.AlunoProfessorExercicio;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Gustavo
 */
public class AlunoProfExercicioDao extends GenericDao {

    public AlunoProfExercicioDao() {
    }
    
 /*   public void excluirAluno(Aluno aluno) {
        Session session = null;
        try {
            session = ConexaoHibernate.getSessionFactory().openSession();
            session.beginTransaction();

            // Carrega o aluno caso não esteja gerenciado pela sessão
            if (!session.contains(aluno)) {
                aluno = session.get(Aluno.class, aluno.getId());
            }

            // Antes de excluir o aluno, remova as referências nas listas associadas
            for (AlunoProfessorExercicio atividade : aluno.getAtividades()) {
                atividade.getChavePK().getProfessor().getAtividades().remove(atividade);
                atividade.getChavePK().getExercicio().getAtividades().remove(atividade);
            }
            aluno.getAtividades().clear();

            // Exclui o aluno
            session.delete(aluno);

            session.getTransaction().commit();
        } catch (HibernateException error) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new HibernateException(error);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }*/
    
    public boolean existeAtribuicao(AlunoProfessorExercicio alProEx){
        boolean existe = false;
        List<AlunoProfessorExercicio> lista = new ArrayList();
        
        
        lista = super.listar(alProEx.getClass());
        
        
        for(AlunoProfessorExercicio alunoProfEx : lista){
            if(alunoProfEx.equals(alProEx) ){
                existe = true;
                break;
            }
        
        }
        
        return existe;
        
    }
}
