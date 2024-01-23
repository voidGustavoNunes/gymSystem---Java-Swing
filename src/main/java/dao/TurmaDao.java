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
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import model.Aulas;
import model.Turma;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gustavo
 */
public class TurmaDao extends GenericDao {

    public TurmaDao() {
    }

    private List<Turma> pesquisar(String pesq, int tipo) {
        List<Turma> lista = new ArrayList();

        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // CRITERIA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Turma.class);

            // TABELAS
            Root tabela = consulta.from(Turma.class);

            tabela.fetch("aulas", JoinType.INNER);
            consulta.distinct(true);

            //RESTRIÇÕES
            Predicate restricoes = null;
            switch (tipo) {
                case 1:
                    restricoes = builder.like(tabela.get("nome"), pesq + "%");
                    break;
                case 2:
                    Join<Turma, Aulas> joinAulas = tabela.join("aulas");
                    restricoes = builder.like(joinAulas.get("tipo"), pesq + "%");
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

    public void adicionarTurmaAulas(Aulas aulas, Turma novaTurma) {
        Session session = ConexaoHibernate.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Carregar a instância de Aulas
            Aulas aulasCarregadas = session.get(Aulas.class, aulas.getIdAula()); // Use o ID de Aulas ou a referência carregada anteriormente

            // Certifique-se de que a coleção de turmas esteja inicializada
            aulasCarregadas.getTurmas().size();

            // Adicione a nova Turma à coleção de turmas em Aulas
            aulasCarregadas.getTurmas().add(novaTurma);

            // Salve a instância de Aulas, o que persistirá a nova Turma
            session.saveOrUpdate(aulasCarregadas);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private Turma pesquisarObj(String pesq, int tipo) {
        Turma turmaEncontrada = null;

        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // CRITERIA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Turma> consulta = builder.createQuery(Turma.class);

            // TABELAS
            Root<Turma> tabela = consulta.from(Turma.class);

            // RESTRIÇÕES
            Predicate restricoes = null;
            switch (tipo) {
                case 1:
                    restricoes = builder.like(tabela.get("nome"), pesq + "%");
                    break;
                case 2:
                    Join<Turma, Aulas> joinAulas = tabela.join("aulas");
                    restricoes = builder.like(joinAulas.get("tipo"), pesq + "%");
                    break;
            }

            consulta.select(tabela).where(restricoes);
            turmaEncontrada = sessao.createQuery(consulta).uniqueResult();
            sessao.getTransaction().commit();
            sessao.close();

        } catch (HibernateException erro) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }
        return turmaEncontrada;
    }

    public Turma pesquisarNome(String pesq) {
        return pesquisarObj(pesq, 2);
    }

    public List<Turma> pesquisarListaNome(String pesq) {
        return pesquisar(pesq, 1);

    }


    public List<Turma> pesquisarAulas(String pesq) {
        return pesquisar(pesq, 2);
    }

}
