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
import model.Exercicio;
import model.Pessoa;
import model.Professor;
import model.Turma;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Gustavo
 */
public class ProfessorDao extends GenericDao {

    public ProfessorDao() {
    }

    private List<Professor> pesquisar(String pesq, int tipo) {
        List<Professor> lista = new ArrayList();

        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // CRITERIA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Professor.class);

            // TABELAS
            Root tabela = consulta.from(Professor.class);

            tabela.fetch("aulas", JoinType.LEFT);
            consulta.distinct(true);

            //RESTRIÇÕES
            Predicate restricoes = null;
            switch (tipo) {
                case 1:
                    restricoes = builder.like(tabela.get("nome"), pesq + "%");
                    break;
                case 2:
                    restricoes = builder.like(tabela.get("cpf"), pesq + "%");
                    break;
                case 3:
                    restricoes = builder.like(tabela.get("numeroRegistro"), pesq + "%");
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

    public List<Aulas> carregarListaAulas(Professor professor) {
        Session session = null;
        try {
            session = ConexaoHibernate.getSessionFactory().openSession();
            session.beginTransaction();

            // Verifica se a lista JÁ FOI CARREGADA
            if (!Hibernate.isInitialized(professor.getAulas())) {

                // Carrega o PROXY para outro objeto
                Professor professorTemp = session.get(Professor.class, professor.getId());

                // Carrega a lista de AULAS
                List<Aulas> lista = professorTemp.getAulas();

                // Carrega os dados do banco
                lista.size();

                // Atualiza a lista na entidade Professor passada como parâmetro
                professor.setAulas(lista);
            }

            session.getTransaction().commit();
        } catch (HibernateException error) {
            if (session != null && session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new HibernateException(error);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return professor.getAulas();
    }

    private List<Professor> pesquisar() {
        //List<Cliente> lista = new ArrayList();

        //return lista;
        // TESTE
        return listar(Professor.class);
    }

    public List<Professor> pesquisarNome(String pesq) {
        return pesquisar(pesq, 1);
    }

    public List<Professor> pesquisarNome() {
        return pesquisar();
    }

    public List<Professor> pesquisarCPF(String pesq) {
        return pesquisar(pesq, 2);
    }

    public List<Professor> pesquisarNumeroRegistro(String pesq) {
        return pesquisar(pesq, 3);
    }

}
