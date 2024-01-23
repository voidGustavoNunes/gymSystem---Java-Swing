/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import model.Aluno;
import model.AlunoProfessorExercicio;
import model.Exercicio;
import model.Professor;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Gustavo
 */
public class ExercicioDao extends GenericDao {

    public ExercicioDao() {
    }

    private List<Exercicio> pesquisar(String pesq, int tipo) {
        List<Exercicio> lista = new ArrayList();
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // CRITERIA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Exercicio.class);

            // TABELAS
            Root tabela = consulta.from(Exercicio.class);

            //RESTRIÇÕES
            Predicate restricoes = null;
            switch (tipo) {
                // where nomeCliente LIKE 'pesq%'
//                case 1:
//                    restricoes = builder.like(tabela.get("id"), pesq + "%");
//                    break;
                case 2:
                    restricoes = builder.like(tabela.get("nome"), pesq + "%");
                    break;
                case 3:
                    pesq = pesq.replaceAll("[\\[\\]\"]", "");

                    restricoes = builder.like(builder.lower(tabela.get("funcao")), "%" + pesq.toLowerCase() + "%");
                    break;
                case 4:
                    Integer series = Integer.parseInt(pesq);
                    restricoes = builder.equal(tabela.get("series"), builder.literal(series));

                    break;

            }

            consulta.where(restricoes);
            lista = sessao.createQuery(consulta).getResultList();
            sessao.getTransaction().commit();
            sessao.close();

        } catch (HibernateException erro) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }
        return lista;

    }

    public List<Exercicio> pesquisarID(int id) {
        List<Exercicio> lista = new ArrayList();
        Exercicio ped = (Exercicio) load(Exercicio.class, id);
        lista.add(ped);
        return lista;
    }

    public List<Exercicio> pesquisar() {

        return listar(Exercicio.class);
    }

    public List<Exercicio> pesquisarNome(String pesq) {
        return pesquisar(pesq, 2);
    }

//    public List<Exercicio> pesquisarId(String pesq) {
//        return pesquisar(pesq, 1);
//    }
    public List<Exercicio> pesquisarFuncao(String pesq) {
        return pesquisar(pesq, 3);
    }

    public List<Exercicio> pesquisarSerie(String pesq) {
        return pesquisar(pesq, 4);
    }

}
